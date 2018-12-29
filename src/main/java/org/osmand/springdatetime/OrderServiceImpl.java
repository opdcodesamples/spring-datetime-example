package org.osmand.springdatetime;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService {
	
	private final OrderRepository orderRepository;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public OrderServiceImpl(OrderRepository orderRepository) {		
		this.orderRepository = orderRepository;
	}
	
	@Override
	public OrderBean getOrder() {
		Iterable<Order> orders = orderRepository.findAll();
		
		if(!orders.iterator().hasNext()) {
			
			Calendar currentDate = Calendar.getInstance();
			
			Order order = new Order(1);
			order.setDescription("iPhone 8 Plus Gold");
			order.setStatus("New");
			
			order.setOrderDate(new Timestamp(
			        ZonedDateTime.of(
			        		currentDate.get(Calendar.YEAR), 
			        		currentDate.get(Calendar.MONTH)  +1, 
			        		currentDate.get(Calendar.DAY_OF_MONTH), 
			        		17,  
			        		0,  
			        		0, 
			        		0, 
			                ZoneId.of("UTC")
			            ).toInstant().toEpochMilli()
			        ));
			
			orderRepository.save(order);
		}
		
		Order order = orderRepository.findAll().iterator().next();
		
		Calendar calDate =  Calendar.getInstance();
		calDate.setTime(order.getOrderDate());
	
		logger.info("Calendar Date on loading Order: " + calDate);
		logger.info("Year: " + calDate.get(Calendar.YEAR));
		logger.info("Month: " + (calDate.get(Calendar.MONTH) + 1));
		logger.info("Day: " + calDate.get(Calendar.DAY_OF_MONTH) );
		logger.info("Hour: " + calDate.get(Calendar.HOUR_OF_DAY) );
		logger.info("Minute: " + calDate.get(Calendar.MINUTE) );
		logger.info("Second: " + calDate.get(Calendar.SECOND) );
		logger.info("Millisecond: " + calDate.get(Calendar.MILLISECOND) );
		logger.info("AM/PM: " + calDate.get(Calendar.AM_PM) );
		logger.info("TimeZone: " + calDate.getTimeZone() );
		
		OrderBean bean = new OrderBean();
		bean.setDescription(order.getDescription());
		bean.setId(order.getId());
		bean.setOrderDate(new Date(order.getOrderDate().getTime()));
		bean.setStatus(order.getStatus());
		bean.setVersion(order.getVersion());
		return bean;
	}

	@Override
	public OrderBean saveOrder(OrderBean orderBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderBean updateOrder(OrderBean orderBean) {
		
		Optional<Order> orderOptional = orderRepository.findById(orderBean.getId());
		
		Calendar calDate =  Calendar.getInstance();
		calDate.setTime(orderBean.getOrderDate());
	
		logger.info("Calendar Date Before Update Order: " + calDate);
		logger.info("Year: " + calDate.get(Calendar.YEAR));
		logger.info("Month: " + (calDate.get(Calendar.MONTH) + 1));
		logger.info("Day: " + calDate.get(Calendar.DAY_OF_MONTH) );
		logger.info("Hour: " + calDate.get(Calendar.HOUR_OF_DAY) );
		logger.info("Minute: " + calDate.get(Calendar.MINUTE) );
		logger.info("Second: " + calDate.get(Calendar.SECOND) );
		logger.info("Millisecond: " + calDate.get(Calendar.MILLISECOND) );
		logger.info("AM/PM: " + calDate.get(Calendar.AM_PM) );
		logger.info("TimeZone: " + calDate.getTimeZone() );
		
		
		if(orderOptional.isPresent()) {
			Order order = orderOptional.get();
			order.setDescription(orderBean.getDescription());
			order.setId(orderBean.getId());
			order.setOrderDate(new Timestamp(
			        ZonedDateTime.of(
			        		calDate.get(Calendar.YEAR), 
			        		calDate.get(Calendar.MONTH)  +1, 
			        		calDate.get(Calendar.DAY_OF_MONTH), 
			        		17,  
			        		0,  
			        		0, 
			        		0, 
			                ZoneId.of("UTC")
			            ).toInstant().toEpochMilli()
			        ));
			order.setStatus(orderBean.getStatus());
			order.setVersion(orderBean.getVersion());
			
			Calendar calDate2 =  Calendar.getInstance();
			calDate.setTime(order.getOrderDate());
		
			logger.info("Calendar Date Just before Update Order: " + calDate2);
			logger.info("Year: " + calDate2.get(Calendar.YEAR));
			logger.info("Month: " + (calDate2.get(Calendar.MONTH) + 1));
			logger.info("Day: " + calDate2.get(Calendar.DAY_OF_MONTH) );
			logger.info("Hour: " + calDate2.get(Calendar.HOUR_OF_DAY) );
			logger.info("Minute: " + calDate2.get(Calendar.MINUTE) );
			logger.info("Second: " + calDate2.get(Calendar.SECOND) );
			logger.info("Millisecond: " + calDate2.get(Calendar.MILLISECOND) );
			logger.info("AM/PM: " + calDate2.get(Calendar.AM_PM) );
			logger.info("TimeZone: " + calDate2.getTimeZone() );
			
			orderRepository.save(order);
			return orderBean;
			
		} else {
			return null;
		}
		
	}
	
	

    
}
