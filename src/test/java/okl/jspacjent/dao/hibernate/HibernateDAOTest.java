package okl.jspacjent.dao.hibernate;

import okl.jspacjent.dao.*;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.springframework.context.support.*;

/**
 * HibernateDao Test Base.
 *
 * @author Janusz Swó³
 */
@Ignore
public class HibernateDAOTest extends AbstractDAOTest {
	
  static Logger log = Logger.getLogger( HibernateDAOTest.class.getName() );

  @Override
  protected String[] getConfigLocations() {
    return new String[]{"testApplicationContext.xml"};
  }

  @Override
  protected DAO createDao(){	  
    log.info(" ...Config locations : " + getConfigLocations()[0]);
    applicationContext = new ClassPathXmlApplicationContext( getConfigLocations() );    
    DAO dao = (HibernateDAO)applicationContext.getBean("dao");
    return dao;
  }

  @Override
  protected void beforeAssertions() {	  
    if ( dao == null ) {
      dao = createDao();
    }
    else {
      ((HibernateDAO)dao).getHibernateTemplate().flush();
    }
  }
  
  @Override
  protected void afterAssertions() {
    if ( dao != null ) {
      ((HibernateDAO) dao).getHibernateTemplate().clear();
      ((HibernateDAO) dao).closeDatabaseConnection();
    }    
  }


  @Override
  protected void onTearDownInTransaction() throws Exception {
    super.onTearDownInTransaction();
    clearCache();
  }

  private void clearCache() {
    /*
    SessionFactory sessionFactory =
      ((HibernateDAO) dao).getSessionFactory();
    */
  }  
  
}
