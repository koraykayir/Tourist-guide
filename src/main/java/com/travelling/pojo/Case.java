/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelling.pojo;

import com.travelling.dao.CaseDAO;
import com.travelling.dao.CaseXCategoryDAO;
import com.travelling.dao.DayDAO;
import com.travelling.entity.CbrCase;
import com.travelling.entity.CbrCaseXCategory;
import com.travelling.entity.CbrCategory;
import com.travelling.entity.CbrDay;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Stefan
 */
public class Case {
    private Integer id;
    private Date startTime;
    private Date endTime;
    private Integer money;
    private Integer numberOfDays;
    private Map<CbrCategory, Double> preferences = new HashMap<CbrCategory, Double>();
    private List<Day> days = new LinkedList<Day>();
    
    public Case() {
        
    }
    
    public Case(CbrCase c) {
        id = c.getId();
        startTime = c.getStartTime();
        endTime = c.getEndTime();
        money = c.getMoney();
        numberOfDays = c.getDays();
        
        for (CbrCaseXCategory cxc : CaseXCategoryDAO.instance.findByCase(c)) {
            preferences.put(cxc.getFkCategory(), cxc.getWeight());
        }
        
        for (CbrDay day : DayDAO.instance.findByCase(c)) {
            days.add(new Day(day));
        }
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the startTime
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the endTime
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * @return the money
     */
    public Integer getMoney() {
        return money;
    }

    /**
     * @param money the money to set
     */
    public void setMoney(Integer money) {
        this.money = money;
    }

    /**
     * @return the preferences
     */
    public Map<CbrCategory, Double> getPreferences() {
        return preferences;
    }

    /**
     * @param preferences the preferences to set
     */
    public void setPreferences(Map<CbrCategory, Double> preferences) {
        this.preferences = preferences;
    }

    /**
     * @return the days
     */
    public List<Day> getDays() {
        return days;
    }

    /**
     * @param days the days to set
     */
    public void setDays(List<Day> days) {
        this.days = days;
    }
    
    public boolean save() {
        CbrCase c;
        if (id == null) c = new CbrCase();
        else c = CaseDAO.instance.find(id);
        if (c == null) return false;
        c.setStartTime(startTime);
        c.setEndTime(endTime);
        c.setMoney(money);
        c.setDays(getNumberOfDays());
        
        for (Map.Entry<CbrCategory, Double> e : preferences.entrySet()) {
            CbrCaseXCategory cxc = new CbrCaseXCategory();
            cxc.setFkCase(c);
            cxc.setFkCategory(e.getKey());
            cxc.setWeight(e.getValue());
        }
        
        int p = 1;
        for (Day day : days) {
            boolean ok = day.save(c, p++);
            if (!ok) return false;
        }
        
        try {
            c = CaseDAO.instance.update(c);
            id = c.getId();
        }
        catch (Exception ex) {
            return false;
        }
             
        return true;
    }

    /**
     * @return the numberOfDays
     */
    public Integer getNumberOfDays() {
        return numberOfDays;
    }

    /**
     * @param numberOfDays the numberOfDays to set
     */
    public void setNumberOfDays(Integer numberOfDays) {
        this.numberOfDays = numberOfDays;
    }
    
}
