package com.longxia.hibernate.dao.impl;
// default package

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;

import com.longxia.entities.Bar;

/**
 	* A data access object (DAO) providing persistence and search support for Bar entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Bar
  * @author MyEclipse Persistence Tools 
 */

@Repository
public class BarDAO extends BaseHibernateDAO  {
		 private static final Log log = LogFactory.getLog(BarDAO.class);
		//property constants
	public static final String NAME = "name";
	public static final String ATTENTION_COUNT = "attentionCount";



    
    public void save(Bar transientInstance) {
        log.debug("saving Bar instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Bar persistentInstance) {
        log.debug("deleting Bar instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Bar findById( java.lang.Integer id) {
        log.debug("getting Bar instance with id: " + id);
        try {
            Bar instance = (Bar) getSession()
                    .get("Bar", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Bar instance) {
        log.debug("finding Bar instance by example");
        try {
            List results = getSession()
                    .createCriteria("Bar")
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
      log.debug("finding Bar instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Bar as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List findByAttentionCount(Object attentionCount
	) {
		return findByProperty(ATTENTION_COUNT, attentionCount
		);
	}
	

	public List findAll() {
		log.debug("finding all Bar instances");
		try {
			String queryString = "from Bar";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Bar merge(Bar detachedInstance) {
        log.debug("merging Bar instance");
        try {
            Bar result = (Bar) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Bar instance) {
        log.debug("attaching dirty Bar instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Bar instance) {
        log.debug("attaching clean Bar instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}