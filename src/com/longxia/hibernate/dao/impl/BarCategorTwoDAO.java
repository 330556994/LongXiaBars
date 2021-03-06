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

import com.longxia.entities.BarCategorTwo;

/**
 	* A data access object (DAO) providing persistence and search support for BarCategorTwo entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .BarCategorTwo
  * @author MyEclipse Persistence Tools 
 */

@Repository
public class BarCategorTwoDAO extends BaseHibernateDAO  {
		 private static final Log log = LogFactory.getLog(BarCategorTwoDAO.class);
		//property constants
	public static final String CATEGORYNAME = "categoryname";



    
    public void save(BarCategorTwo transientInstance) {
        log.debug("saving BarCategorTwo instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(BarCategorTwo persistentInstance) {
        log.debug("deleting BarCategorTwo instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public BarCategorTwo findById( java.lang.Integer id) {
        log.debug("getting BarCategorTwo instance with id: " + id);
        try {
            BarCategorTwo instance = (BarCategorTwo) getSession()
                    .get("BarCategorTwo", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(BarCategorTwo instance) {
        log.debug("finding BarCategorTwo instance by example");
        try {
            List results = getSession()
                    .createCriteria("BarCategorTwo")
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
      log.debug("finding BarCategorTwo instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from BarCategorTwo as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByCategoryname(Object categoryname
	) {
		return findByProperty(CATEGORYNAME, categoryname
		);
	}
	

	public List findAll() {
		log.debug("finding all BarCategorTwo instances");
		try {
			String queryString = "from BarCategorTwo";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public BarCategorTwo merge(BarCategorTwo detachedInstance) {
        log.debug("merging BarCategorTwo instance");
        try {
            BarCategorTwo result = (BarCategorTwo) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(BarCategorTwo instance) {
        log.debug("attaching dirty BarCategorTwo instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(BarCategorTwo instance) {
        log.debug("attaching clean BarCategorTwo instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}