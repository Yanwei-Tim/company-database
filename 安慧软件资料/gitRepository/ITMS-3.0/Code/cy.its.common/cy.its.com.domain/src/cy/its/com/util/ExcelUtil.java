/**
 * @Title: ExcelUtil.java
 * @Package cy.its.com.util
 * @Description: Excel���������ɹ�����
 * @author wangk@cychina.cn
 * @date 2016��3��30�� ����6:05:38
 * @version V1.0
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2016 
 */
package cy.its.com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * 
  * @ClassName: ExcelUtil
  * @Description: Excel���������ɹ�����
  * @author wangk@cychina.cn
  * @date 2016��3��31�� ����9:01:08
  *
 */
public class ExcelUtil<T> {

	
	/**
	 * ����excel ��ȡÿ��sheet�е�ÿ������
	 * 
	 * @Title: readExcel
	 * @param inputStream	�ļ���
	 * @param ignoreRows ����ǰ���У����Ե�һ�д�1��
	 * @return
	 * @throws IOException
	 * @return List<String[]> 
	 * @throws InvalidFormatException 
	 */
	public static List<List<String[]>> readExcel(InputStream inputStream,int ignoreRows) throws IOException, InvalidFormatException {
		//���ؽ����
		List<List<String[]>> resultList = new ArrayList<List<String[]>>();
		boolean isNotNullRow = false;
		 try {
			 Workbook workbook = WorkbookFactory.create(inputStream);
			 Cell cell = null;
			 //ѭ��excel ��ȡÿ��sheet
			 for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
				 List<String[]> oneSheetList = new ArrayList<String[]>();
				//����������ȡsheet
				Sheet sheet = workbook.getSheetAt(sheetIndex);
				//ѭ��sheet ��ȡÿ�����ݣ��Ӻ�������һ�п�ʼ��
				for (int rowIndex = ignoreRows; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
					//�������ÿ��cell��ֵ��Ϊ�� ��Ϊfalse
					isNotNullRow = false;
					Row row = sheet.getRow(rowIndex);
					if(row == null) continue;
					String[] rowValueArray = new String[row.getLastCellNum()];
					//��ȡ���е�ÿ��
					for(int columnIndex = 0 ; columnIndex < row.getLastCellNum(); columnIndex++){
						cell = row.getCell(columnIndex);
						String cellValue ="";
						//����cell���ͷֱ��ȡֵ
						if(cell != null){
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								cellValue = cell.getStringCellValue();
								break;
							case Cell.CELL_TYPE_NUMERIC:
								if(org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)){
									Date date = cell.getDateCellValue();
									if(date != null){
										cellValue = new SimpleDateFormat("yyyy-MM-dd").format(date);
									}
								}else{
									cellValue = new DecimalFormat("0").format(cell.getNumericCellValue());
								}
								break;
							case Cell.CELL_TYPE_FORMULA:
								 // ����ʱ���Ϊ��ʽ���ɵ���������ֵ
								if (!cell.getStringCellValue().equals("")) {
									cellValue = cell.getStringCellValue();
								}else{
									cellValue = cell.getNumericCellValue() + "";
								}
								break;
							case Cell.CELL_TYPE_BLANK:
		                        break;
		                    case Cell.CELL_TYPE_ERROR:
		                    	cellValue = "";
		                        break;
		                    case Cell.CELL_TYPE_BOOLEAN:
		                    	cellValue = cell.getBooleanCellValue() == true ? "Y" : "N";
		                        break;    
							default:
								cellValue = "";
								break;
							}
						}else{
							cellValue = "";
						}
						
						rowValueArray[columnIndex] = cellValue.trim();
						//��һ��cell��Ϊ����Ϊtrue
						isNotNullRow = isNotNullRow == true ? true : (cellValue != null && !"".equals(cellValue.trim()));
					}
					
					if(isNotNullRow){
						oneSheetList.add(rowValueArray);
					}
				}
				resultList.add(oneSheetList);
			}
		 
		 } catch (InvalidFormatException e) {
				e.printStackTrace();
				throw e;
		 }
		 
		return resultList;
	}
	
	
	/**
	 * ����excel ��ȡÿ��sheet�е�ÿ������
	 * 
	 * @Title: readExcel
	 * @param path	excel·���������ļ�����
	 * @param ignoreRows ����ǰ���У����Ե�һ�д�1��
	 * @return List<String[]> 
	 * @throws IOException
	 * @throws InvalidFormatException 
	 */
	public static List<List<String[]>> readExcel(String path,int ignoreRows) throws IOException, InvalidFormatException {
		
		 return readExcel(new FileInputStream(new File(path)), ignoreRows);
		 
	}
	
	/**
	 * ����excel ��ȡÿ��sheet�е�ÿ������(Ĭ�ϵ�һ�в�ȡ)
	 * 
	 * @Title: readExcel
	 * @param path excel·��
	 * @return List<String[]>
	 * @throws IOException
	 * @throws InvalidFormatException 
	 */
	public static List<List<String[]>> readExcel(String path) throws IOException, InvalidFormatException {
		
		return readExcel(path,1);
	}
	
	
	/**
	 * ����excel ��ȡÿ��sheet�е�ÿ������(Ĭ�ϵ�һ�в�ȡ)
	 * 
	 * @Title: readExcel
	 * @param inputStream �ļ���
	 * @return List<String[]>
	 * @throws IOException
	 * @throws InvalidFormatException 
	 */
	public static List<List<String[]>> readExcel(InputStream inputStream) throws IOException, InvalidFormatException {
		
		return readExcel(inputStream,1);
	}
	
	/**
	 * �������б���������excel(2007) ������������ 
	 *
	 * @Title: exportExcel
	 * @param collection   	Collection<T> Ҫ����excel������
	 * @param keys       	String[] collection�з������е�������
	 * @param header     	�������
	 * @param outputStream	�����
	 * @param format	���ڸ�ʽ
	 * @return void
	 * @throws NoSuchMethodException 
	 * @throws IllegalAccessException 
	 * @throws IOException 
	 * @throws InvocationTargetException 
	 */
	public void exportExcel(Collection<T> collection,String[] fieldNameArr,String[] headers,OutputStream outputStream,String format) throws NoSuchMethodException, IllegalAccessException, IOException, InvocationTargetException {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		sheet.setDefaultColumnWidth(20);
		
		//��������ʽ
		XSSFCellStyle cellStyleHeader = workbook.createCellStyle();
        cellStyleHeader.setBorderBottom(XSSFCellStyle.BORDER_THIN);//�ײ��߿�  
        cellStyleHeader.setBorderLeft(XSSFCellStyle.BORDER_THIN);//��߿�    
        cellStyleHeader.setBorderRight(XSSFCellStyle.BORDER_THIN);//�ұ߿�    
        cellStyleHeader.setBorderTop(XSSFCellStyle.BORDER_THIN);//�ϲ��߿�    
        cellStyleHeader.setAlignment(XSSFCellStyle.ALIGN_CENTER);//���Ҿ���  
        cellStyleHeader.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());//ǰ��ɫ
        cellStyleHeader.setFillPattern(CellStyle.SOLID_FOREGROUND); //���������ʽ
        // ���ɱ�������  
        XSSFFont font = workbook.createFont();  
        font.setFontHeightInPoints((short) 11);//�����С  
        font.setFontName("Arial");//����
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);//����  
        // ������Ӧ�õ���ǰ����ʽ  
        cellStyleHeader.setFont(font);  
        
        //��������ʽ
        XSSFCellStyle  cellStyleData = workbook.createCellStyle();  
        cellStyleData.setBorderBottom(XSSFCellStyle.BORDER_THIN);//�ײ��߿�    
        cellStyleData.setBorderLeft(XSSFCellStyle.BORDER_THIN);//��߿�      
        cellStyleData.setBorderRight(XSSFCellStyle.BORDER_THIN);//�ұ߿�      
        cellStyleData.setBorderTop(XSSFCellStyle.BORDER_THIN);//�ϲ��߿�      
        cellStyleData.setAlignment(XSSFCellStyle.ALIGN_CENTER); //���Ҿ���   
        cellStyleData.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);//���¾���  
        cellStyleData.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());//ǰ��ɫ
        cellStyleData.setFillPattern(CellStyle.SOLID_FOREGROUND); //���������ʽ

        // ������������  
        XSSFFont dataFont = workbook.createFont();  
        dataFont.setBoldweight(XSSFFont.BOLDWEIGHT_NORMAL);//�Ǵ���
        dataFont.setFontHeightInPoints((short) 10);//�����С  
        dataFont.setFontName("Arial");//����
        // ������Ӧ�õ�������ʽ  
        cellStyleData.setFont(dataFont);  
        // ����һ����ͼ�Ķ���������  
        XSSFDrawing patriarch = sheet.createDrawingPatriarch();  
        
        //��������  
        XSSFRow rowHeader = sheet.createRow(0);  
        for (int i = 0; i < headers.length; i++){  
            XSSFCell cellHeader = rowHeader.createCell(i);
            cellHeader.setCellStyle(cellStyleHeader);
            cellHeader.setCellValue(headers[i]);  
        } 
        
        try {
        
	        int indexRow = 1;
	        int indexCell = 0;
	        //ѭ�������ݷ���sheet��
	        for(T t : collection){
	        	XSSFRow dataRow = sheet.createRow(indexRow++); 
	        	indexCell = 0;
	        	
	        	for(String fieldName : fieldNameArr){
	        		
	        		 XSSFCell cellData = dataRow.createCell(indexCell++);  
	        		 cellData.setCellStyle(cellStyleData);
	        		String getFieldName =  "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1); 
	        		Class<?> classT = t.getClass();
	        		Method method = classT.getMethod(getFieldName,new Class[]{});
	        		Object value = method.invoke(t, new Object[]{});
	        		String valueStr = "";
	        		
	        		if(value instanceof Date){
	        			valueStr = DateUtil.parseFormatDate((Date)value, format);
	        			cellData.setCellValue(valueStr); 
	        		}else if(value instanceof Boolean){
	        			valueStr = (Boolean) value ? "Y" : "N" ;
	        			cellData.setCellValue(valueStr); 
	        		}else if (value instanceof byte[]){  
	                    // ��ͼƬʱ�������и�Ϊ60px;  
	        			dataRow.setHeightInPoints(60);  
	                    // ����ͼƬ�����п��Ϊ80px,ע�����ﵥλ��һ������  
	                    sheet.setColumnWidth(indexCell, (int) (35.7*80));  
	                    byte[] bsValue = (byte[]) value;  
	                    XSSFClientAnchor anchor = new XSSFClientAnchor(0, 0, 1023, 255, (short) 6, indexRow, (short) 6, indexRow);  
	                    anchor.setAnchorType(2);  
	                    patriarch.createPicture(anchor, workbook.addPicture(bsValue, XSSFWorkbook.PICTURE_TYPE_JPEG));  
	                }else{
	                	valueStr = String.valueOf(value == null ? "" : value);
	                	cellData.setCellValue(valueStr); 
	                }
	        	}
	        	
	        }
	        workbook.write(outputStream);
	        outputStream.flush();
	        outputStream.close();
        
        } catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw e;
		} catch (SecurityException e) {
			e.printStackTrace();
			throw e;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw e;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw e;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
    	
	}
	
	
	
	/**
	 * �������б���������excel(2007) ������������ 
	 * �������������ʽĬ��Ϊyyyy-MM-dd
	 *
	 * @Title: exportExcel
	 * @param collection   	Collection<T> Ҫ����excel������
	 * @param keys       	String[] collection�з��͵�������
	 * @param header     	�������
	 * @param outputStream	�����
	 * @return void
	 * @throws IOException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws NoSuchMethodException 
	 */
	public void exportExcel(Collection<T> collection,String[] fieldNameArr,String[] headers,OutputStream outputStream) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {
		exportExcel(collection, fieldNameArr, headers, outputStream,"yyyy-MM-dd");
	}
	
	
	/**
	 * ����������excel(2007) ������������
	 *
	 * @Title: exportExcel
	 * @param dataList   	List<Map<String, String>> Ҫ����excel������
	 * @param keys       	String[] dataList��ÿ��map��key
	 * @param header     	�������
	 * @param outputStream	�����
	 * @return void
	 * @throws IOException 
	 */
	public static void exportExcel(List<Map<String, String>> dataList,String[] keys,String[] headers,OutputStream outputStream,Map<String,String> title) throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		sheet.setDefaultColumnWidth(20);
		// ������ʽ
		XSSFCellStyle cellStyleTitle = workbook.createCellStyle();
		cellStyleTitle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);// ���¾���
		// ���ɱ�������
		XSSFFont fontTitle = workbook.createFont();
		fontTitle.setFontHeightInPoints((short) 16);// �����С
		fontTitle.setFontName("����");// ����
		// ������Ӧ�õ���ǰ����ʽ
		cellStyleTitle.setFont(fontTitle);
		
		// ���ɱ�����������
		XSSFFont fontTitleText = workbook.createFont();
		fontTitleText.setFontHeightInPoints((short) 10);// �����С
		fontTitleText.setFontName("����");// ����
		
		//��������ʽ
		XSSFCellStyle cellStyleHeader = workbook.createCellStyle();
        cellStyleHeader.setBorderBottom(XSSFCellStyle.BORDER_THIN);//�ײ��߿�  
        cellStyleHeader.setBorderLeft(XSSFCellStyle.BORDER_THIN);//��߿�    
        cellStyleHeader.setBorderRight(XSSFCellStyle.BORDER_THIN);//�ұ߿�    
        cellStyleHeader.setBorderTop(XSSFCellStyle.BORDER_THIN);//�ϲ��߿�    
        cellStyleHeader.setAlignment(XSSFCellStyle.ALIGN_CENTER);//���Ҿ���  
        cellStyleHeader.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);//���¾���  
        cellStyleHeader.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());//ǰ��ɫ
        cellStyleHeader.setFillPattern(CellStyle.SOLID_FOREGROUND); 
        // ���ɱ�������  
        XSSFFont font = workbook.createFont();  
        font.setFontHeightInPoints((short) 11);//�����С  
        font.setFontName("Arial");//����
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);//����  
        // ������Ӧ�õ���ǰ����ʽ  
        cellStyleHeader.setFont(font);  
        
        //��������ʽ
        XSSFCellStyle  cellStyleData = workbook.createCellStyle();  
        cellStyleData.setBorderBottom(XSSFCellStyle.BORDER_THIN);//�ײ��߿�    
        cellStyleData.setBorderLeft(XSSFCellStyle.BORDER_THIN);//��߿�      
        cellStyleData.setBorderRight(XSSFCellStyle.BORDER_THIN);//�ұ߿�      
        cellStyleData.setBorderTop(XSSFCellStyle.BORDER_THIN);//�ϲ��߿�      
        cellStyleData.setAlignment(XSSFCellStyle.ALIGN_CENTER); //���Ҿ���   
        cellStyleData.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);//���¾���  
        cellStyleData.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());//ǰ��ɫ
        cellStyleData.setFillPattern(CellStyle.SOLID_FOREGROUND); 

        // ������������  
        XSSFFont dataFont = workbook.createFont();  
        dataFont.setBoldweight(XSSFFont.BOLDWEIGHT_NORMAL);//�Ǵ���
        dataFont.setFontHeightInPoints((short) 10);//�����С  
        dataFont.setFontName("Arial");//����
        // ������Ӧ�õ�������ʽ  
        cellStyleData.setFont(dataFont);  
        
        //excel�������� 
		XSSFRow titleRow = sheet.createRow(0);
		for (int i = 0; i < headers.length; i++) {
			XSSFCell cellHeader = titleRow.createCell(i);
			XSSFCellStyle  cellStyle = (XSSFCellStyle) cellStyleTitle.clone();
			cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);//���Ҿ���
			cellHeader.setCellValue(title.get("title"));
			cellHeader.setCellStyle(cellStyle);
		}
		titleRow.setHeight((short) 1000);
		sheet.addMergedRegion(new CellRangeAddress(0, (short) 0, 0, (short) headers.length - 1));// ָ���ϲ�����

		// excel������������
		XSSFRow queryRow = sheet.createRow(1);
		for (int i = 0; i < headers.length; i++) {
			XSSFCell cellHeader = queryRow.createCell(i);
			XSSFCellStyle  cellStyleRow = (XSSFCellStyle) cellStyleTitle.clone();
			cellStyleRow.setAlignment(XSSFCellStyle.ALIGN_LEFT);//���Ҿ���
			// �������廻��
			cellStyleRow.setWrapText(true);
			// ������Ӧ�õ���ǰ����ʽ
			cellStyleRow.setFont(fontTitleText);
			cellHeader.setCellValue(title.get("param"));
			cellHeader.setCellStyle(cellStyleRow);
		}
		queryRow.setHeight((short) 600);
		sheet.addMergedRegion(new CellRangeAddress(1, (short) 1, 0, (short) headers.length - 1));// ָ���ϲ�����
        
        //���ݱ�����  
        XSSFRow rowHeader = sheet.createRow(2);  
        for (int i = 0; i < headers.length; i++){  
            XSSFCell cellHeader = rowHeader.createCell(i);  
            cellHeader.setCellStyle(cellStyleHeader);
            cellHeader.setCellValue(headers[i]);  
        } 
        
        int indexRow = 3;
        int indexCell = 0;
        //ѭ�������ݷ���sheet��
        for(Map<String,String> dataMap : dataList){
        	XSSFRow dataRow = sheet.createRow(indexRow++); 
        	indexCell = 0;
        	for(String key : keys){
        		XSSFCell cellData = dataRow.createCell(indexCell++);  
        		cellData.setCellStyle(cellStyleData);
        		cellData.setCellValue( dataMap.get(key) == null ? "" : dataMap.get(key) ); 
        	}
        }
        
        try {
			workbook.write(outputStream);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
        
	}
	
}
