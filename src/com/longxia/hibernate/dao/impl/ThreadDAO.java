package com.longxia.hibernate.dao.impl;
// default package

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.longxia.entities.Thread;

/**
 	* A data access object (DAO) providing persistence and search support for Thread entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Thread
  * @author MyEclipse Persistence Tools 
 */

public class ThreadDAO extends BaseHibernateDAO  {
		 private static final Log log = LogFactory.getLog(ThreadDAO.class);
		//property constants
	public static final String TITLE = "title";
	public static final String CONTENT = "content";
	public static final String IMAGE = "image";
	public static final String IS_TOP = "isTop";
	public static final String REPLYCOUNT = "replycount";



    
    public void save(Thread transientInstance) {
        log.debug("saving Thread instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Thread persistentInstance) {
        log.debug("deleting Thread instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Thread findById( java.lang.Integer id) {
        log.debug("getting Thread instance with id: " + id);
        try {
            Thread instance = (Thread) getSession()
                    .get("Thread", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Thread instance) {
        log.debug("finding Thread instance by example");
        try {
            List results = getSession()
                    .createCriteria("Thread")
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
      log.debug("finding Thread instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Thread as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByTitle(Object title
	) {
		return findByProperty(TITLE, title
		);
	}
	
	public List findByContent(Object content
	) {
		return findByProperty(CONTENT, content
		);
	}
	
	public List findByImage(Object image
	) {
		return findByProperty(IMAGE, image
		);
	}
	
	public List findByIsTop(Object isTop
	) {
		return findByProperty(IS_TOP, isTop
		);
	}
	
	public List findByReplycount(Object replycount
	) {
		return findByProperty(REPLYCOUNT, replycount
		);
	}
	

	public List findAll() {
		log.debug("finding all Thread instances");
		try {
			String queryString = "from Thread";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Thread merge(Thread detachedInstance) {
        log.debug("merging Thread instance");
        try {
            Thread result = (Thread) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Thread instance) {
        log.debug("attaching dirty Thread instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Thread instance) {
        log.debug("attaching clean Thread instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}