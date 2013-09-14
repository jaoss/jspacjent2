/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package okl.jspacjent.utility;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JS
 */
public class TextFileTest {
  
  public TextFileTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() {
  }
  
  @After
  public void tearDown() {
  }

  /** */
  @Test
  public void write_czynnosci() throws IOException {
    System.out.println("czynnoœci - usage");
    String line;
    String prefix = "INSERT INTO `med_procedure` ( `data`, `pesel`, `symbol_kasa`,`primary_data`, `additional_data`,  `symbol_proc_type`, `no_adm`, `surcharge`, `amount`, `description`) VALUES (";
    String suffix = "";
    String name_from = "c:/tmp/test-czynnosci-01.sql"; //=="one"
    String name_to   = "c:/tmp/test.sql";              //=="two"
    TextFile textFile = new TextFile(name_from);    
    PrintWriter out = new PrintWriter( new BufferedWriter(new FileWriter( name_to )));
    for( int i = 0; i < textFile.getSize(); i++ ) {
      line = textFile.getAt(i);
      if ( line.endsWith(",") ) {
         suffix = "\"\");";
      };
      if ( line.endsWith("\"") ) {
         suffix = ");";
      };
      out.println( prefix + "\r\n" + line + suffix + "\r\n" );      
      out.flush();
      suffix = "";
    }
    out.close();
  }  
  
}
