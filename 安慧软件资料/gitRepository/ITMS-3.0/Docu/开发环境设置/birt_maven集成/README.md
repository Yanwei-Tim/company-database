### Maven����Birt 4.4.2�汾���κ�����
����viewservletsֻ��4.4.1�汾��������ָ��

### Maven����Birt 4.5.0�汾���⴦����
ԭ�򣺹ٷ�Maven����ֿ���Birt 4.5.0 �汾�����⡣org.eclipse.equinox.common��org.eclipse.core.runtime�汾�����Ͼ���jar����ǩ���ļ���һ�¡�org.mozilla.javascript���������汾�����°汾��ͻ��
����취��
1���ֹ��ϴ�org.eclipse.equinox.common-3.7.0.v20150402-1709.jar��org.eclipse.osgi-3.10.100.v20150529-1857.jar����������Maven˽����
��ʹ�����²����ϴ���
		<dependency>
			<groupId>org.eclipse.birt.runtime</groupId>
			<artifactId>org.eclipse.equinox.common</artifactId>
			<version>3.7.0.v20150402-1709</version>
		</dependency>
		<dependency>
			<groupId>org.eclipse.birt.runtime</groupId>
			<artifactId>org.eclipse.core.runtime</artifactId>
			<version>3.11.0.v20150405-1723</version>
		</dependency>
2��ʹ������pom.xml

		<dependency>
			<groupId>org.eclipse.birt.runtime</groupId>
			<artifactId>viewservlets</artifactId>
			<version>${birt_version}</version>
		</dependency>
		<dependency>
			<groupId>javax.xml.rpc</groupId>
			<artifactId>javax.xml.rpc-api</artifactId>
			<version>1.1.1</version>
		</dependency>
		<dependency>
			<groupId>org.eclipse.birt.runtime</groupId>
			<artifactId>org.eclipse.core.runtime</artifactId>
			<version>3.11.0.v20150405-1723</version>
		</dependency>
		
		<dependency>
			<groupId>org.eclipse.birt.runtime</groupId>
			<artifactId>org.eclipse.birt.runtime</artifactId>
			<exclusions>
				<exclusion>
					<groupId>org.eclipse.birt.runtime</groupId>
					<artifactId>org.eclipse.equinox.common</artifactId>
				</exclusion>
				<exclusion>
					<artifactId>org.mozilla.javascript</artifactId>
					<groupId>org.eclipse.birt.runtime.3_7_1</groupId>
				</exclusion>
			</exclusions> 
		</dependency>
		<dependency>
			<groupId>org.eclipse.birt.runtime</groupId>
			<artifactId>org.eclipse.equinox.common</artifactId>
			<version>3.7.0.v20150402-1709</version>
		</dependency>
		
### Birt ����鿴�����Ļ�
1���ֹ��ϴ�org.eclipse.birt.report.viewer.nl_zh_4.5.0.v20150804081228.jar������Maven˽����
��ʹ�����²����ϴ���
		<dependency>
			<groupId>org.eclipse.birt.runtime</groupId>
			<artifactId>org.eclipse.birt.report.viewer.nl_zh</artifactId>
			<version>4.5.0</version>
		</dependency>
2��ʹ������pom.xml
		<dependency>
			<groupId>org.eclipse.birt.runtime</groupId>
			<artifactId>org.eclipse.birt.report.viewer.nl_zh</artifactId>
			<version>${birt_version}</version>
		</dependency>