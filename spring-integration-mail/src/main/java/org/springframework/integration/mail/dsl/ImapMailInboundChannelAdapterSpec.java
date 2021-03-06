/*
 * Copyright 2014-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.integration.mail.dsl;

import org.springframework.integration.mail.ImapMailReceiver;
import org.springframework.integration.mail.SearchTermStrategy;

/**
 * A {@link MailInboundChannelAdapterSpec} for IMAP.
 *
 * @author Gary Russell
 * @author Artem Bilan
 *
 * @since 5.0
 */
public class ImapMailInboundChannelAdapterSpec
		extends MailInboundChannelAdapterSpec<ImapMailInboundChannelAdapterSpec, ImapMailReceiver> {

	ImapMailInboundChannelAdapterSpec() {
		super(new ImapMailReceiver());
	}

	ImapMailInboundChannelAdapterSpec(ImapMailReceiver imapMailReceiver) {
		super(imapMailReceiver, true);
	}

	ImapMailInboundChannelAdapterSpec(String url) {
		super(new ImapMailReceiver(url), false);
	}

	/**
	 * A {@link SearchTermStrategy} to use.
	 * @param searchTermStrategy the searchTermStrategy.
	 * @return the spec.
	 * @see ImapMailReceiver#setSearchTermStrategy(SearchTermStrategy)
	 */
	public ImapMailInboundChannelAdapterSpec searchTermStrategy(SearchTermStrategy searchTermStrategy) {
		assertReceiver();
		this.receiver.setSearchTermStrategy(searchTermStrategy);
		return this;
	}

	/**
	 * A flag to determine if message should be marked as read.
	 * @param shouldMarkMessagesAsRead the shouldMarkMessagesAsRead.
	 * @return the spec.
	 * @see ImapMailReceiver#setShouldMarkMessagesAsRead(Boolean)
	 */
	public ImapMailInboundChannelAdapterSpec shouldMarkMessagesAsRead(boolean shouldMarkMessagesAsRead) {
		assertReceiver();
		this.receiver.setShouldMarkMessagesAsRead(shouldMarkMessagesAsRead);
		return this;
	}

	/**
	 * How often to recycle the idle task (in case of a silently dropped connection).
	 * Seconds; default 120 (2 minutes).
	 * @param interval the interval.
	 * @return the spec.
	 * @see ImapMailReceiver#setCancelIdleInterval(long)
	 * @since 5.0.10
	 * @deprecated since 5.2: there is no idle task started for polling channel adapter.
	 */
	@Deprecated
	public ImapMailInboundChannelAdapterSpec cancelIdleInterval(long interval) {
		assertReceiver();
		this.receiver.setCancelIdleInterval(interval);
		return this;
	}

}
