/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpivTestLink;

import testlink.api.java.client.TestLinkAPIClient;

public class SeleniumIntegracao {
	
	public static final String TESTLINK_KEY = "c0b2c042b0bc966b86f716737a77a1e1";
	public static final String TESTLINK_URL ="http://www.lesse.com.br/testlink/lib/api/xmlrpc/v1/xmlrpc.php";
	public static final String TEST_PROJECT_NAME = "Gerenciador Pampatec - Grupo 04";
	public static final String TEST_PLAN_NAME = "RPIV Test Plan";
	public static final String TEST_CASE_NAME ="ExampleTestCase";//Mudar pro nome do meu caso de teste
	public static final String BUILD_NAME = "Build Grupo04";
	
	public static void updateResults(String testCaseName, String exception, String results) throws  testlink.api.java.client.TestLinkAPIException{
		TestLinkAPIClient testLink = new TestLinkAPIClient(TESTLINK_KEY,TESTLINK_URL);
		testLink.reportTestCaseResult(TEST_PROJECT_NAME, TEST_PLAN_NAME, testCaseName, BUILD_NAME, exception, results);
	}
}

