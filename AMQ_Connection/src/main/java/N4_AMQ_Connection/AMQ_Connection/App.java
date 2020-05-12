package N4_AMQ_Connection.AMQ_Connection;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;


public class App 
{
	public static void main (String[] args) throws JMSException {
		/* URL of the JMS server. Default http://n4mqtest01:8161/admin/queues.jsp?QueueFilter=DEV.PBT is the local host.
		 * default broker URL is : tcp://localhost:6166
		 *  
		 */
         //String url =  System.getProperty("http://n4mqtest01:8161/admin/queues.jsp?QueueFilter=DEV.PBT",  ActiveMQConnection.DEFAULT_BROKER_URL);
         
			//String url =   ActiveMQConnection.DEFAULT_BROKER_URL;
		
		//String url = "http://n4mqtest01:8161/admin/queues.jsp?QueueFilter=DEV.PBT";
		
		// String url = "tcp://n4mqtest01:8161";
		String url = "tcp://n4mqtest01:61616";
		//String url = "tcp://10.111.221.203:62910";
			
		
		/* 61616
			 * Queue Name. You can create any/many queue names as per your requirement
			 *  
			 */
			
			//String queueName = "DEV.PBT.INHIGHPRIO";
		     String queueName = "DEV.PBT.INSTARTUP";
		
		
		System.out.println("url = "+ url);
		
	/*
	 * Getting JMS Connection from the JMS server and starting it	
	 */
		
	ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
	Connection connection = connectionFactory.createConnection();
	//connection.start();
	
	/*
	 * Creating a non transactional session to send/receive JMS message
	 */
	
	Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	
	/*
	 * The queue will be created automatically on the server 
	 */
	
	Destination destination = session.createQueue(queueName);
	
	/*
	 * Destination represents here our queue 'MESSAGE_QUEUE' on the JMS server
	 * MessageProducer is used for sending messages to the queue
	 * 
	 */
	MessageProducer producer = session.createProducer(destination);
	TextMessage message = session.createTextMessage("<RTCSExchangeLane>\r\n" + 
			"  <header>\r\n" + 
			"    <senderId>RTCS</senderId>\r\n" + 
			"    <receiverId>N4</receiverId>\r\n" + 
			"    <msgType>exchangeLane</msgType>\r\n" + 
			"    <msgId>123456789</msgId>\r\n" + 
			"    <timeStamp>2020-03-30 11:55:28</timeStamp>\r\n" + 
			"  </header>\r\n" + 
			"  <body>\r\n" + 
			"    <exchangeLane action=\"SWIPE\" msic=\"170998\" laneId=\"04\" />\r\n" + 
			"  </body>\r\n" + 
			"</RTCSExchangeLane>\r\n");	
//VV_PENDING: Success	
	TextMessage messageVV_PENDING = session.createTextMessage("<RTCSBulkRequest>\r\n" + 
			"  <header>\r\n" + 
			"    <senderId>RTCS</senderId>\r\n" + 
			"    <receiverId>N4</receiverId> \r\n" + 
			"    <msgType>bulkRequest</msgType> \r\n" + 
			"    <msgId>2</msgId> \r\n" + 
			"    <timeStamp>2020-03-30 11:55:28</timeStamp> \r\n" + 
			"  </header>\r\n" + 
			"  <body> \r\n" + 
			"    <bulkRequest action=\"VV_PENDING\"/> \r\n" + 
			"  </body>\r\n" + 
			" </RTCSBulkRequest>\r\n");
	
	TextMessage messageVV_CURRENT = session.createTextMessage("<RTCSBulkRequest>\r\n" + 
			"  <header>\r\n" + 
			"    <senderId>RTCS</senderId>\r\n" + 
			"    <receiverId>N4</receiverId> \r\n" + 
			"    <msgType>bulkRequest</msgType> \r\n" + 
			"    <msgId>3</msgId> \r\n" + 
			"    <timeStamp>2020-03-30 11:55:28</timeStamp> \r\n" + 
			"  </header>\r\n" + 
			"  <body> \r\n" + 
			"    <bulkRequest action=\"VV_CURRENT\"/> \r\n" + 
			"  </body>\r\n" + 
			" </RTCSBulkRequest>\r\n");
	
	TextMessage messageTRK_PENDING = session.createTextMessage("<RTCSBulkRequest>\r\n" + 
			"  <header>\r\n" + 
			"    <senderId>RTCS</senderId>\r\n" + 
			"    <receiverId>N4</receiverId> \r\n" + 
			"    <msgType>bulkRequest</msgType> \r\n" + 
			"    <msgId>4</msgId> \r\n" + 
			"    <timeStamp>2020-03-30 11:55:28</timeStamp> \r\n" + 
			"  </header>\r\n" + 
			"  <body> \r\n" + 
			"    <bulkRequest action=\"TRK_PENDING\"/> \r\n" + 
			"  </body>\r\n" + 
			" </RTCSBulkRequest>\r\n");
	
	TextMessage messageTRK_CURRENT = session.createTextMessage("<RTCSBulkRequest>\r\n" + 
			"  <header>\r\n" + 
			"    <senderId>RTCS</senderId>\r\n" + 
			"    <receiverId>N4</receiverId> \r\n" + 
			"    <msgType>bulkRequest</msgType> \r\n" + 
			"    <msgId>5</msgId> \r\n" + 
			"    <timeStamp>2020-03-30 11:55:28</timeStamp> \r\n" + 
			"  </header>\r\n" + 
			"  <body> \r\n" + 
			"    <bulkRequest action=\"TRK_CURRENT\"/> \r\n" + 
			"  </body>\r\n" + 
			" </RTCSBulkRequest>\r\n");
	TextMessage messageCTR_PENDING = session.createTextMessage("<RTCSBulkRequest>\r\n" + 
			"  <header>\r\n" + 
			"    <senderId>RTCS</senderId>\r\n" + 
			"    <receiverId>N4</receiverId> \r\n" + 
			"    <msgType>bulkRequest</msgType> \r\n" + 
			"    <msgId>6</msgId> \r\n" + 
			"    <timeStamp>2020-03-30 11:55:28</timeStamp> \r\n" + 
			"  </header>\r\n" + 
			"  <body> \r\n" + 
			"    <bulkRequest action=\"CTR_PENDING\"/> \r\n" + 
			"  </body>\r\n" + 
			" </RTCSBulkRequest>\r\n");
	TextMessage messageCTR_CURRENT = session.createTextMessage("<RTCSBulkRequest>\r\n" + 
			"  <header>\r\n" + 
			"    <senderId>RTCS</senderId>\r\n" + 
			"    <receiverId>N4</receiverId> \r\n" + 
			"    <msgType>bulkRequest</msgType> \r\n" + 
			"    <msgId>7</msgId> \r\n" + 
			"    <timeStamp>2020-03-30 11:55:28</timeStamp> \r\n" + 
			"  </header>\r\n" + 
			"  <body> \r\n" + 
			"    <bulkRequest action=\"CTR_CURRENT\"/> \r\n" + 
			"  </body>\r\n" + 
			" </RTCSBulkRequest>\r\n");			
	TextMessage messageWQ_ROAD = session.createTextMessage("<RTCSBulkRequest>\r\n" + 
			"  <header>\r\n" + 
			"    <senderId>RTCS</senderId>\r\n" + 
			"    <receiverId>N4</receiverId> \r\n" + 
			"    <msgType>bulkRequest</msgType> \r\n" + 
			"    <msgId>8</msgId> \r\n" + 
			"    <timeStamp>2020-03-30 11:55:28</timeStamp> \r\n" + 
			"  </header>\r\n" + 
			"  <body> \r\n" + 
			"    <bulkRequest action=\"WQ_ROAD\"/> \r\n" + 
			"  </body>\r\n" + 
			" </RTCSBulkRequest>\r\n");
	TextMessage messageWQ_VESSEL = session.createTextMessage("<RTCSBulkRequest>\r\n" + 
			"  <header>\r\n" + 
			"    <senderId>RTCS</senderId>\r\n" + 
			"    <receiverId>N4</receiverId> \r\n" + 
			"    <msgType>bulkRequest</msgType> \r\n" + 
			"    <msgId>9</msgId> \r\n" + 
			"    <timeStamp>2020-03-30 11:55:28</timeStamp> \r\n" + 
			"  </header>\r\n" + 
			"  <body> \r\n" + 
			"    <bulkRequest action=\"WQ_VESSEL\"/> \r\n" + 
			"  </body>\r\n" + 
			" </RTCSBulkRequest>\r\n");
	TextMessage messageWQ_YARD = session.createTextMessage("<RTCSBulkRequest>\r\n" + 
			"  <header>\r\n" + 
			"    <senderId>RTCS</senderId>\r\n" + 
			"    <receiverId>N4</receiverId> \r\n" + 
			"    <msgType>bulkRequest</msgType> \r\n" + 
			"    <msgId>10</msgId> \r\n" + 
			"    <timeStamp>2020-03-30 11:55:28</timeStamp> \r\n" + 
			"  </header>\r\n" + 
			"  <body> \r\n" + 
			"    <bulkRequest action=\"WQ_YARD\"/> \r\n" + 
			"  </body>\r\n" + 
			" </RTCSBulkRequest>\r\n");
	
	
	/*
	 * Here we are sending our message
	 */
	
	/*producer.send(message);
	System.out.println("Message:  "+ message.getText()+", Sent successfully to the Queue");*/
	
	producer.send(messageVV_PENDING);
	System.out.println("Message:  "+ messageVV_PENDING.getText()+", Sent successfully to the Queue");
	//connection.close();
	
	producer.send(messageVV_CURRENT);
	System.out.println("Message:  "+ messageVV_CURRENT.getText()+", Sent successfully to the Queue");
	
	producer.send(messageTRK_PENDING);
	System.out.println("Message:  "+ messageTRK_PENDING.getText()+", Sent successfully to the Queue");
	
	producer.send(messageTRK_CURRENT);
	System.out.println("Message:  "+ messageTRK_CURRENT.getText()+", Sent successfully to the Queue");
	
	producer.send(messageCTR_PENDING);
	System.out.println("Message:  "+ messageCTR_PENDING.getText()+", Sent successfully to the Queue");
	
	producer.send(messageCTR_CURRENT);
	System.out.println("Message:  "+ messageCTR_CURRENT.getText()+", Sent successfully to the Queue");
	
	producer.send(messageWQ_ROAD);
	System.out.println("Message:  "+ messageWQ_ROAD.getText()+", Sent successfully to the Queue");
	
	producer.send(messageWQ_VESSEL);
	System.out.println("Message:  "+ messageWQ_VESSEL.getText()+", Sent successfully to the Queue");
	
	producer.send(messageWQ_YARD);
	System.out.println("Message:  "+ messageWQ_YARD.getText()+", Sent successfully to the Queue");
	
	
	}	

}
