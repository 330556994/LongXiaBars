package com.longxia.hibernate.dao.impl;
// default package

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.longxia.entities.LevelName;

/**
 	* A data access object (DAO) providing persistence and search support for LevelName entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .LevelName
  * @author MyEclipse Persistence Tools 
 */

public class LevelNameDAO extends BaseHibernateDAO  {
		 private static final Log log = LogFactory.getLog(LevelNameDAO.class);
		//property constants
	public static final String LEVELNAME = "levelname";
	public static final String LEVEL = "level";



    
    public void save(LevelName transientInstance) {
        log.debug("saving LevelName instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(LevelName persistentInstance) {
        log.debug("deleting LevelName instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public LevelName findById( java.lang.Integer id) {
        log.debug("getting LevelName instance with id: " + id);
        try {
            LevelName instance = (LevelName) getSession()
                    .get("LevelName", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(LevelName instance) {
        log.debug("finding LevelName instance by example");
        try {
            List results = getSession()
                    .createCriteria("LevelName")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding LevelName instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from LevelName as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByLevelname(Object levelname
	) {
		return findByProperty(LEVELNAME, levelname
		);
	}
	
	public List findByLevel(Object level
	) {
		return findByProperty(LEVEL, level
		);
	}
	

	public List findAll() {
		log.debug("finding all LevelName instances");
		try {
			String queryString = "from LevelName";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public LevelName merge(LevelName detachedInstance) {
        log.debug("merging LevelName instance");
        try {
            LevelName result = (LevelName) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(LevelName instance) {
        log.debug("attaching dirty LevelName instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(LevelName instance) {
        log.debug("attaching clean LevelName instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}