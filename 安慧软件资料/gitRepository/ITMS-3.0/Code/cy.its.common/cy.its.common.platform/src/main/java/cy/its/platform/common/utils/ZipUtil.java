package cy.its.platform.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

/**
* @Title: ZipUtil.java 
* @Package cy.its.platform.common.utils 
* @Description:ѹ���ļ�������
* @author lil@cychina.cn
* @date 2015��11��23�� ����2:15:40 
* @version V1.0   
 */
public class ZipUtil {
	/**
     * ��ֹѹ���ļ�����������
     */
    private static final String ZIP_ENCODING = "GBK";
 
    /**
     * ˽�еĹ��췽��
     */
    private ZipUtil(){}
 
    /**
     * ѹ���ļ�
     * @param srcFile ��Ҫѹ�����ļ�
     * @param zipFile ѹ������ļ�(.zip��׺��Ҫ�Լ����)
     * @param overwrite ���ļ��Ѵ���ʱ�Ƿ񸲸�
     * @throws IOException
     */
    public static void zipFile(File srcFile, File zipFile, boolean overwrite) throws IOException {
        if (zipFile == null || srcFile == null) {
            throw new IllegalArgumentException("zipFile��srcFile����Ϊ��!");
        }
        if (!overwrite && zipFile.exists()) {
            throw new IOException(zipFile.getAbsolutePath() + "�ļ��Ѵ��ڣ������趨�˲��ܸ��ǡ�");
        }
        if (!zipFile.exists()) {
            zipFile.createNewFile();
        }
 
        FileInputStream fileInput = new FileInputStream(srcFile);
        ZipOutputStream zipOutput = new ZipOutputStream(new FileOutputStream(zipFile));
        zipOutput.setEncoding(ZIP_ENCODING);
 
        byte[] buffer = new byte[2048];
        ZipEntry zipEntry = new ZipEntry(srcFile.getName());    //ѹ����������ļ���
        zipOutput.putNextEntry(zipEntry);
 
        int len;
        while ((len = fileInput.read(buffer)) != -1) {
            zipOutput.write(buffer, 0, len);
            zipOutput.flush();
        }
        fileInput.close();
        zipOutput.close();
    }
 
    /**
     * ѹ��һ���ļ�����ͬ���ļ����ڣ��򸲸�֮��
     * @param srcFile ��Ҫѹ�����ļ�
     * @param zipFile ѹ�����ɵ��ļ�
     * @throws IOException
     */
    public static void zipFile(File srcFile, File zipFile) throws IOException {
        zipFile(srcFile, zipFile, true);
    }
 
    /**
     * ��ѹ��һ���ļ������ɵ��ļ���Ϊ��Դ�ļ���.zip��������ͬ���ļ����򸲸�֮��
     * @param srcFile ��Ҫѹ�����ļ�
     * @throws IOException ѹ�����ɵ��ļ�
     */
    public static void zipFile(File srcFile) throws IOException {
        zipFile(srcFile, new File(srcFile.getAbsolutePath() + ".zip"), true);
    }
 
    /**
     * ѹ��һ��Ŀ¼��
     * @param srcDir ��Ҫѹ����Ŀ¼
     * @param zipFile ѹ������ļ�
     * @param overwrite �Ƿ񸲸��Ѵ����ļ�
     * @throws IOException
     */
    public static void zipDirectory(File srcDir, File zipFile, boolean overwrite) throws IOException {
        if (zipFile == null || srcDir == null) {
            throw new IllegalArgumentException("zipFile��srcDir����Ϊ��!");
        }
        if (!overwrite && zipFile.exists()) {
            throw new IOException(zipFile.getAbsolutePath() + "�ļ��Ѵ��ڣ������趨�˲��ܸ��ǡ�");
        }
        if (!zipFile.exists()) {
            zipFile.createNewFile();
        }
 
        ZipOutputStream zipOutput = new ZipOutputStream(new FileOutputStream(zipFile));
        zipOutput.setEncoding(ZIP_ENCODING);
        zipDirectory(zipOutput, srcDir, srcDir.getName());
        zipOutput.close();
    }
 
    /**
     * ѹ��Ŀ¼�ĸ����������ݹ�����Ŀ¼��
     * @param zipOutput zip�����
     * @param file ��ǰ�ļ�
     * @param base ��ǰ�ļ���ѹ������ľ�������
     * @throws IOException
     */
    private static void zipDirectory(ZipOutputStream zipOutput, File file, String base) throws IOException {
        if (file.isDirectory()) {
            File[] fileList = file.listFiles();
            zipOutput.putNextEntry(new ZipEntry(base + "/"));
            base = (base.length() == 0) ? "" : base + "/";
            for (File childFile: fileList) {
                zipDirectory(zipOutput, childFile, base + childFile.getName());
            }
        }
        else {
            zipOutput.putNextEntry(new ZipEntry(base));
            FileInputStream fileInputStream = new FileInputStream(file);
            int length;
            byte[] buffer = new byte[2048];
            while ( (length = fileInputStream.read(buffer)) != -1) {
                zipOutput.write(buffer, 0, length);
                zipOutput.flush();
            }
            fileInputStream.close();
        }
    }
 
    /**
     * ѹ��һ��Ŀ¼���������ͬ���ļ�����Ḳ��
     * @param srcDir ��Ҫѹ�� ��Ŀ¼
     * @param zipFile ѹ���������ļ�
     * @throws IOException
     */
    public static void zipDirectory(File srcDir, File zipFile) throws IOException {
        zipDirectory(srcDir, zipFile, true);
    }
 
    /**
     * ѹ��һ��Ŀ¼��ѹ��������ļ���Ϊ(Ŀ¼��.zip)
     * @param srcDir ��Ҫѹ����Ŀ¼
     * @throws IOException
     */
    public static void zipDirectory(File srcDir) throws IOException {
        zipDirectory(srcDir, new File(srcDir.getAbsolutePath()+".zip"), true);
    }
 
    /**
     * ��һ���ļ��������ѹ�������鳤�ȱ������0
     * @param files �ļ����顣���ȱ������0
     * @param zipFile ѹ����������ļ�
     * @param overwrite �����ͬ���ļ����Ƿ񸲸�
     * @throws IOException
     */
    public static void zipFiles(File[] files, File zipFile, boolean overwrite) throws IOException {
        if (zipFile == null || files == null) {
            throw new IllegalArgumentException("zipFile��srcDir����Ϊ��!");
        }
        if (files.length == 0) {
            throw new IOException("���ܶ�һ���յ��ļ��б����ѹ��");
        }
        if (!overwrite && zipFile.exists()) {
            throw new IOException(zipFile.getAbsolutePath() + "�ļ��Ѵ��ڣ������趨�˲��ܸ��ǡ�");
        }
        if (!zipFile.exists()) {
            zipFile.createNewFile();
        }
 
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile));
        zipOutputStream.setEncoding(ZIP_ENCODING);
        byte[] buffer = new byte[2048];
        int length;
        for (File file: files) {
            FileInputStream fileInputStream = new FileInputStream(file);
            zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
            while ((length = fileInputStream.read(buffer)) != -1) {
                zipOutputStream.write(buffer, 0, length);
                zipOutputStream.flush();
            }
            fileInputStream.close();
        }
 
        zipOutputStream.close();
    }
 
    /**
     * ��һ���ļ��б����ѹ�����б��ȳ��ȱ������0
     * @param fileList �ļ��б����ȱ������0
     * @param zipFile ѹ����������ļ�
     * @param overwrite ����Ѿ�����ͬ���ļ����Ƿ񸲸ǡ�
     * @throws IOException
     */
    public static void zipFiles(List<File> fileList, File zipFile, boolean overwrite) throws IOException {
        zipFiles(fileList.toArray(new File[fileList.size()]), zipFile, overwrite);
    }
 
    /**
     * ��һ���ļ��б����ѹ�����б��ȳ��ȱ������0�������ͬ��Ŀ���ļ�����Ḳ������
     * @param fileList �ļ��б����ȱ������0
     * @param zipFile  ѹ�������ɵ��ļ�
     * @throws IOException
     */
    public static void zipFiles(List<File> fileList, File zipFile) throws IOException {
        zipFiles(fileList.toArray(new File[fileList.size()]), zipFile, true);
    }
 
    /**
     * ��һ���ļ��������ѹ�������鳤�ȱ������0�������ͬ��Ŀ���ļ�����Ḳ������
     * @param files �ļ����顣���ȱ������0
     * @param zipFile ѹ�������ɵ��ļ�
     * @throws IOException
     */
    public static void zipFiles(File[] files, File zipFile) throws IOException {
        zipFiles(files, zipFile, true);
    }
 
    /**
     * ���Է���
     * @param args ����
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        List<File> fileList = new ArrayList<File>();
        fileList.add(new File("D:/1.txt"));
        fileList.add(new File("D:/2.txt"));
//      File[] files = {new File("D:/1.txt"), new File("D:/2.txt")};
        zipFiles(fileList, new File("D:/test.zip"));
        zipDirectory(new File("D:/user"), new File("D:/user.zip"), true);
    }
 
}
