package com.longxia.hibernate.dao.impl;
// default package

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.longxia.entities.UserAttention;

/**
 	* A data access object (DAO) providing persistence and search support for UserAttention entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .UserAttention
  * @author MyEclipse Persistence Tools 
 */

public class UserAttentionDAO extends BaseHibernateDAO  {
		 private static final Log log = LogFactory.getLog(UserAttentionDAO.class);
		//property constants



    
    public void save(UserAttention transientInstance) {
        log.debug("saving UserAttention instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(UserAttention persistentInstance) {
        log.debug("deleting UserAttention instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UserAttention findById( java.lang.Integer id) {
        log.debug("getting UserAttention instance with id: " + id);
        try {
            UserAttention instance = (UserAttention) getSession()
                    .get("UserAttention", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(UserAttention instance) {
        log.debug("finding UserAttention instance by example");
        try {
            List results = getSession()
                    .createCriteria("UserAttention")
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
      log.debug("finding UserAttention instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UserAttention as model where model." 
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
		log.debug("finding all UserAttention instances");
		try {
			String queryString = "from UserAttention";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public UserAttention merge(UserAttention detachedInstance) {
        log.debug("merging UserAttention instance");
        try {
            UserAttention result = (UserAttention) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(UserAttention instance) {
        log.debug("attaching dirty UserAttention instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UserAttention instance) {
        log.debug("attaching clean UserAttention instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}