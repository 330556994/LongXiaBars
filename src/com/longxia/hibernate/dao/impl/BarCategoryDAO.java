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

import com.longxia.entities.BarCategory;

/**
 	* A data access object (DAO) providing persistence and search support for BarCategory entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .BarCategory
  * @author MyEclipse Persistence Tools 
 */
@Repository
public class BarCategoryDAO extends BaseHibernateDAO  {
		 private static final Log log = LogFactory.getLog(BarCategoryDAO.class);
		//property constants
	public static final String CATEGORYNAME = "categoryname";

	public void save(BarCategory transientInstance) {
        log.debug("saving BarCategory instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(BarCategory persistentInstance) {
        log.debug("deleting BarCategory instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public BarCategory findById( java.lang.Integer id) {
        log.debug("getting BarCategory instance with id: " + id);
        try {
            BarCategory instance = (BarCategory) getSession()
                    .get("BarCategory", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(BarCategory instance) {
        log.debug("finding BarCategory instance by example");
        try {
            List results = getSession()
                    .createCriteria("BarCategory")
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
      log.debug("finding BarCategory instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from BarCategory as model where model." 
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
		log.debug("finding all BarCategory instances");
		try {
			String queryString = "from BarCategory";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public BarCategory merge(BarCategory detachedInstance) {
        log.debug("merging BarCategory instance");
        try {
            BarCategory result = (BarCategory) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(BarCategory instance) {
        log.debug("attaching dirty BarCategory instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(BarCategory instance) {
        log.debug("attaching clean BarCategory instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}