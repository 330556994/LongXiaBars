package com.longxia.hibernate.dao.impl;
// default package

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.longxia.entities.AttentionBar;

/**
 	* A data access object (DAO) providing persistence and search support for AttentionBar entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .AttentionBar
  * @author MyEclipse Persistence Tools 
 */

public class AttentionBarDAO extends BaseHibernateDAO  {
		 private static final Log log = LogFactory.getLog(AttentionBarDAO.class);
		//property constants



    
    public void save(AttentionBar transientInstance) {
        log.debug("saving AttentionBar instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(AttentionBar persistentInstance) {
        log.debug("deleting AttentionBar instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AttentionBar findById( java.lang.Integer id) {
        log.debug("getting AttentionBar instance with id: " + id);
        try {
            AttentionBar instance = (AttentionBar) getSession()
                    .get("AttentionBar", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(AttentionBar instance) {
        log.debug("finding AttentionBar instance by example");
        try {
            List results = getSession()
                    .createCriteria("AttentionBar")
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
      log.debug("finding AttentionBar instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from AttentionBar as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	public List findAll() {
		log.debug("finding all AttentionBar instances");
		try {
			String queryString = "from AttentionBar";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public AttentionBar merge(AttentionBar detachedInstance) {
        log.debug("merging AttentionBar instance");
        try {
            AttentionBar result = (AttentionBar) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AttentionBar instance) {
        log.debug("attaching dirty AttentionBar instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AttentionBar instance) {
        log.debug("attaching clean AttentionBar instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}