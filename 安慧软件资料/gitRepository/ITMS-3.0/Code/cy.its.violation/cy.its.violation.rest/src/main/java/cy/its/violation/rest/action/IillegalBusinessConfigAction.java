package cy.its.violation.rest.action;

import java.util.Map;

import cy.its.violation.rest.dto.IllegalBusinessConfigDto;


public interface IillegalBusinessConfigAction {
		//��ѯ
		Map searchIllConfig(IllegalBusinessConfigDto illegalBusinessConfigDto);
		//����
		public String goUpdateIllConfig(IllegalBusinessConfigDto illegalBusinessConfigDto);

}
