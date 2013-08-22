package okl.jspacjent.dao.hibernate;

import okl.jspacjent.dao.*;
import org.springframework.context.support.*;

/**
 * HibernateDao Test.
 *
 * @author Janusz Swó³
 */
public class HibernateDAOTest extends AbstractDAOTest {

  @Override
  protected String[] getConfigLocations() {
    return new String[]{"testApplicationContext.xml"};
  }

  @Override
  protected DAO createDao() {
    System.out.println(" ...Config locations : " + getConfigLocations()[0]);
    applicationContext =
      new ClassPathXmlApplicationContext( getConfigLocations() );
    if (applicationContext != null ) {
      System.out.println(" ...Application context : " + applicationContext.getDisplayName() );
    }
    else {
      System.out.println(" ...Application context not created" );
    }
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

  public void testPacjent() {
   
    beforeAssertions();
    /*
    // ...
    List pacjenci = dao.getAllPacjent();
    List kasy     = dao.getAllKasach();
    //
    List lekarze     = dao.getAllLekarz();
    List skierowania = dao.getAllSkierowAsStrings();
    List rozpoznania = dao.getAllRozpoznanieAsStrings();
    //
    List rodzajeBadan    = dao.getAllRodzbad();
    List rodzajeLeczenia = dao.getAllRodzlecz();
    */
    /*
    RodzbadJPanel rodzbadPanel = new RodzbadJPanel( dao );
    RodzbadJDialog rodzbadDialog = 
      new RodzbadJDialog( new java.awt.Frame(), true, rodzbadPanel );
    rodzbadDialog.setVisible(true);
    
    RodzleczJPanel rodzleczPanel = new RodzleczJPanel( dao );
    RodzleczJDialog rodzleczDialog = 
      new RodzleczJDialog( new java.awt.Frame(), true, rodzleczPanel );
    rodzleczDialog.setVisible(true);
    */    
    /*
    Iterator  iter = pacjenci.iterator();
    Pacjent   pacjent; 
    Przyjecie przyjecie;
    
    //while ( iter.hasNext() ) { 
      
      pacjent = (Pacjent)iter.next();
      Set przyjecia = pacjent.getPrzyjecies();
      Iterator iter1 = pacjent.getPrzyjecies().iterator();
      przyjecie = (Przyjecie)iter1.next();
      
      System.out.println(pacjent + " " + pacjent.getKasach() );
      
      PacjentJPanel pacjentPanel = new PacjentJPanel(pacjent, kasy );
      PrzyjecieJPanel przyjeciePanel = 
        new PrzyjecieJPanel(przyjecie, lekarze, skierowania, rozpoznania);
      PacjentDialogUI pacjentDialog =
        new PacjentDialogUI(null, true, pacjentPanel, przyjeciePanel);      
      pacjentDialog.setVisible(true);           
      
      System.out.println(pacjent + " " + pacjent.getKasach() );
      
    //}
    */ 
    /*  
    iter = kasy.iterator(); 
    Kasach kasa; 
    while ( iter.hasNext() ) {   
      kasa = (Kasach)iter.next();
      System.out.println(kasa);
    }
    */
    //afterAssertions();  
  }  
  
}
