package com.arkdex.springinaction.streamrabbitmq;

import com.arkdex.springinaction.streamrabbitmq.model.LogMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = StreamRabbitmqApplication.class)
@DirtiesContext
public class StreamRabbitmqApplicationTests {

	@Autowired
	private Processor pipe;

	@Autowired
	private MessageCollector messageCollector;

	@Test
	public void sendMessage() {
		pipe.input()
				.send(MessageBuilder.withPayload(new LogMessage("This is my message"))
						.build());

		Object payload = messageCollector.forChannel(pipe.output())
				.poll()
				.getPayload();

		assertEquals("[1]: This is my message", payload.toString());
	}

}
