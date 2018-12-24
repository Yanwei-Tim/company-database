package cy.its.service.standardization.validator;

import cy.its.service.common.StringUtil;
import cy.its.service.common.dataModel.MsgInfo;

public class MsgInfoValidator extends BaseValidator<MsgInfo> {

	@Override
	void fillFilters() {
		addFilter(u -> dbLen(u.getSender()) > 32, "Sender���ܴ���32λ;");
		addFilter(u -> u.getSendTime() == null, "SendTime����Ϊ��;");
		addFilter(u -> is1HMoreThanNow(u.getSendTime()), "SendTimeʱ�䳬����ǰʱ��1��Сʱ,��Уʱ;");
		addFilter(u -> dbLen(u.getSendStatus()) > 1, "SendStatus���ܴ���1λ;");
		addFilter(u -> dbLen(u.getMsgType()) > 2, "MsgType���ܴ���2λ;");
		addFilter(u -> dbLen(u.getMsgTitle()) > 128, "MsgTitle���ܴ���128λ;");
		addFilter(u -> StringUtil.isNullOrEmpty(u.getMsgContent()), "MsgContent����Ϊ��;");
		addFilter(u -> dbLen(u.getMsgContent()) > 2048, "MsgContent���ܴ���2048λ;");
		addFilter(u -> StringUtil.isNullOrEmpty(u.getReceiver()), "Receiver����Ϊ��;");
		addFilter(u -> dbLen(u.getReceiver()) > 32, "Receiver���ܴ���32λ;");
		addFilter(u -> dbLen(u.getRemark()) > 256, "Remark���ܴ���256λ;");
	}
}
