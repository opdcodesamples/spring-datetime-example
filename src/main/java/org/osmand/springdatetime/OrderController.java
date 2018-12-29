package org.osmand.springdatetime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Transactional
public class OrderController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private OrderService orderService;
	
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
		
	@RequestMapping({"/"})
    public String loadOrder(Model model){
        logger.info("in loadOrder....");
        model.addAttribute("command", orderService.getOrder());
        return "page";
    }


	@RequestMapping(value = "command", method = RequestMethod.POST)
    public String saveOrUpdate(@ModelAttribute OrderBean orderBean,Model model){
        OrderBean updatedOrderBean = orderService.updateOrder(orderBean);
        model.addAttribute("command", updatedOrderBean);
        return "page";
    }
}
