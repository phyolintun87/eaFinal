package mum.ea.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.ea.domain.Command; 
import mum.ea.domain.Material;
import mum.ea.dto.ResourceDTO; 
@Service
public class ResourceSvrNotifierImpl implements ResourceSvrNotifier{

//	 ApplicationContext context = new GenericXmlApplicationContext("classpath:META-INF/spring/order-app-context.xml");
	 
	@Autowired
    RabbitTemplate restopicTemplate; //=  context.getBean("restopicTemplate",RabbitTemplate.class);

	public String getPayload(Long materialID) {
		// TODO Auto-generated method stub
		ResourceDTO dto=new ResourceDTO();
		dto.setPayLoad(materialID);
		dto.setCommand(Command.GET);
		
		return publishAndGetResponse(dto);
	}

	public void savePayload(Material material) {
		// TODO Auto-generated method stub
		ResourceDTO dto=new ResourceDTO();
		dto.setPayLoad(material);
		dto.setCommand(Command.SAVE);
		
		publish(dto);
	}

	public void deletePayload(Long materialID) {
		// TODO Auto-generated method stub
		ResourceDTO dto=new ResourceDTO();
		dto.setPayLoad(dto);
		dto.setCommand(Command.REMOVE);
		
		publish(dto);
	}

	private String publishAndGetResponse(ResourceDTO dto) {
		 return (String)restopicTemplate.convertSendAndReceive("eaprojectRest.material",dto);
	}
	 
	private void publish(ResourceDTO dto) {
		restopicTemplate.convertAndSend("eaprojectRest.material",dto);
	}

}
