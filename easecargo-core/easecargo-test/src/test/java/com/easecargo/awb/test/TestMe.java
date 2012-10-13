package com.easecargo.awb.test;
 
import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.easecargo.awb.AWB;
import com.easecargo.awb.AccountInfo;
import com.easecargo.awb.Customer;
import com.easecargo.awb.Dimension;
import com.easecargo.awb.HAWB;
import com.easecargo.awb.HandlingInfo;
import com.easecargo.awb.OtherCharges;
import com.easecargo.awb.RateLine;
import com.easecargo.awb.dao.AWBDao;
import com.easecargo.awb.dao.CustomerDao;
import com.easecargo.awb.dao.HAWBDao;
import com.easecargo.awb.service.AWBService;
import com.easecargo.awb.service.CustomerService;
import com.easecargo.awb.service.HAWBService;
import com.easecargo.user.MyAccount;
import com.easecargo.user.User;
import com.easecargo.user.service.AccountService;
import com.easecargo.user.service.UserService;


/**
 * testing comment
 * @author rajesh
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/app-config.xml" })
public class TestMe { 


	Logger logger = LoggerFactory.getLogger(TestMe.class);
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private AWBDao awbDao;
	@Autowired
	private HAWBDao hawbDao;
	@Autowired
	private AWBService awbService;
	@Autowired
	private HAWBService hawbService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private UserService userService;
	@Autowired
	private AccountService accountService;
	

	@Test
	public void testCreateUser() {
		logger.info("testCreateUser Begin");
		logger.info("------------------------");
		User u = new User();
		u.setUserName("Me");
		userService.saveUser(u);
	
		User u1 = new User();
		u1.setUserName("Me2");
		userService.saveUser(u1);
		
		userService.deleteUser(u1);
		
		Assert.assertTrue(userService.getAllUsers().size() > 0);
	
		logger.info("testCreateUser END");
		logger.info("------------------------");
	}
	@Test 
	public void testAccount() {
		User u = userService.getUserByName("Me");
		MyAccount account = new MyAccount();
		account.setUser(u);
		account.setCurrency("Dollar");
		account.setStatus("Valid");
		accountService.saveAccount(account);
		logger.info("Saved MyAccount");
		logger.info("saveAccount END");
		logger.info("------------------------");
		logger.info(accountService.getAccountForUser(u.getUserId()).toString());		
		logger.info("----fetch Account END-------------------");
}
	@Test
	public void testCreateCustomer() {
		logger.info("testCreateCustomer Begin");
		logger.info("------------------------");
		Customer user = new Customer();
		User u = userService.getUserByName("Me");		
		user.setUser(u);
		user.setCustomerName("Adit");
		customerService.saveCustomer(user);
		Assert.assertTrue(customerService.getAllCustomers().size() > 0);
		logger.info("Saved Customer");
		logger.info("testCreateCustomer END");
		logger.info("------------------------");
		logger.info(customerService.getCustomersByUserId(u.getUserId()).toString());
		List<Customer> l = customerService.getCustomersByAccountAndUserId("ac", u.getUserId());
		logger.info("--- total customer with account number like ac is ---"+l.size());
		l=customerService.getCustomersByAWBPrefixAndUserId(157, u.getUserId());
		logger.info("--- total customer with awbprefix 157 is ---"+l.size());
	}
	@Test
	public void testGetCustomer() {
		User u = userService.getUserByName("Me");		
		logger.info("testGetCustomer Begin");
		logger.info("------------------------");
				
		List<Customer> l = customerService.getCustomersByNameAndUserId("Ad",u.getUserId());
		logger.info("Listed Customers "+l.size());
		Assert.assertTrue(l.size()>0);
		
		List<Customer> l1 = customerService.getCustomersByNameAndUserId("Adit1",u.getUserId());
		Assert.assertTrue(l1.size()>0);
		logger.info("Listed Customers "+l1.size());
		logger.info("testGetCustomer END");
		logger.info("------------------------");
		
	}

	@Test
	public void testCreateAWB() {
		logger.info("testCreateAWB Begin");
		logger.info("------------------------");
		
		AWB awb = new AWB();
		User u = userService.getUserByName("Me");		
		awb.setUser(u);		
		awb.setAwbPrefix(157);
		awb.setAwbNumber(111111111);
		awb.setFlightNumber("QR0001");
		
		Customer user = new Customer();
		user.setCustomerName("Adit");
		user.setUser(u);		
		user.setAccountNumber("ac1");
		customerDao.saveCustomer(user);
		
		Customer user1 = new Customer();
		user1.setCustomerName("Adit1");
		user1.setUser(u);		
		customerDao.saveCustomer(user1);
		
		awb.setAgent(user);
		awb.setConsignee(user1);
		awb.setOtherParty(user);
	//	awb.setShipper(user1);
		
		AccountInfo act = new AccountInfo();
		act.setAccountIdentity("10");
		act.setAwb(awb);
		Set<AccountInfo> accountInfos = new java.util.HashSet<AccountInfo>();
		accountInfos.add(act);
		
		HandlingInfo hnd = new HandlingInfo();
		hnd.setHandlignCategory("Cat");
		hnd.setAwb(awb);
		Set<HandlingInfo> handlingInfos = new java.util.HashSet<HandlingInfo>();
		handlingInfos.add(hnd);		

		OtherCharges oc = new OtherCharges();
		oc.setTotalOtherChargesCode("O");
		oc.setAwb(awb);
		Set<OtherCharges> oCharges = new java.util.HashSet<OtherCharges>();
		oCharges.add(oc);		

		RateLine rl = new RateLine();
		rl.setChargedWeight((float) 99.1);
		rl.setAwb(awb);
		
		Dimension dim = new Dimension();
		dim.setHeight((float) 33.1);
		dim.setWidth((float) 44.1);
		dim.setRateLine(rl);
		Set<Dimension> dims = new java.util.HashSet<Dimension>();
		dims.add(dim);
		rl.setDimensions(dims);
		
		Set<RateLine> rateLines = new java.util.HashSet<RateLine>();
		rateLines.add(rl);				
		
		awb.setHandlingInfos(handlingInfos);
		awb.setAccountInfos(accountInfos);
		awb.setOtherCarges(oCharges);
		awb.setRateLines(rateLines);
		awbDao.saveAWB(awb);
		logger.info("Saved AWB");
		logger.info("");		
		logger.info("------------------------");
		Assert.assertTrue(awbDao.getAllAWBs().size() > 0);
		logger.info("");
		logger.info("testCreateAWB Begin");
		logger.info("------------------------");		

		AWB awb1 = awbDao.selectAWBByNumberAndUserId(157,111111111,u.getUserId());
		logger.info("fetched AWB by Number "+awb1.getAwbNumber());
		logger.info("------------------------");		
		List<AWB> awbList2 = awbDao.searchAWB(null, null, null, null, u.getUserId());
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>-"+awbList2.size());
		awbService.saveAWB(awb);
		logger.info("Saved AWB via service");
		logger.info("------------------------");
		AWB a1 = awbService.getAWBByNumberAndUserId(157,111111111, u.getUserId());
		logger.info("fetched AWB via service "+a1.getAwbNumber());
		//logger.info("fetched AWB User via service "+a1.getUser().getUserName());
		logger.info("testCreateAWB END");
		logger.info("------------------------");	
		
	}
	@Test	
	public void testcreateHAWB() {
		User u = userService.getUserByName("Me");
		
		logger.info("testcreateHAWB Begin");
		logger.info("------------------------");
		AWB a2 = awbService.getAWBByNumberAndUserId(157,111111111, u.getUserId());
		logger.info("fetched AWB via service "+a2);
		HAWB hawb = new HAWB();
		hawb.setUser(u);			
		hawb.setAwb(a2);
		hawb.setHawbNum("12345");
		Customer user1 = new Customer();
		user1.setCustomerName("Adit12");
		user1.setUser(u);
		customerDao.saveCustomer(user1);
		
		hawb.setShipper(user1);
		hawb.setConsignee(user1);
		
		hawbDao.saveHAWB(hawb);
		logger.info("------------------------");		
		hawbService.saveHAWB(hawb);
		logger.info("------------------------");		
		HAWB h = hawbService.getHAWB(hawb.getHawbId());
		logger.info("fetched HAWB via service "+ h.getHawbNum());
		logger.info("------------------------");		
		logger.info("fetched HAWB via service "+ hawbService.getHAWB("12345"));
		//logger.info("fetched HAWB via service "+ hawbService.g);
		logger.info("testcreateHAWB End");
		logger.info("------------------------");		
	}
	@Test	
	public void testDeleteAWB() {
		User u = userService.getUserByName("Me");
		AWB a2 = awbService.getAWBByNumberAndUserId(157,111111111,u.getUserId());
		logger.info("fetched AWB via service "+a2);
		AWB a3 = awbService.getAWBByIdAndUserId(19,u.getUserId());
		logger.info("fetched AWB via service "+a3);
		logger.info("------------------------");		
		List<AWB> awbList1 = awbService.getAllAWBByUserId(u.getUserId());
		logger.info("------------------------"+awbList1.size());		
		awbService.deleteAWBByNumberAndUserId(157,111111111,u.getUserId());
		logger.info("Delete done");
		List<AWB> awbList2 = awbService.searchAWB(null, null, 157, null, u.getUserId());
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>-"+awbList2.size());
	}
}
