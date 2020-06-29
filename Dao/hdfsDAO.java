package Dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FsStatus;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

public class hdfsDAO {
	private  FileSystem fs = null;
	
	public  boolean delFile(String filpath) {
		try {
			fs = FileSystem.get(new Configuration());
			boolean delete = fs.delete(new Path(filpath), true);
			if(delete) {
				return delete;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public  boolean createFile(String filePath) {
		
		try {
			fs = FileSystem.get(new Configuration());
			boolean b = fs.createNewFile(new Path(filePath));
			if(b) {
				return b;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public  boolean createDir(String path) {
		try {
			fs = FileSystem.get(new Configuration());
			boolean b = fs.mkdirs(new Path(path));
			if(b) {
				return b;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public  String[] listFiles(String path) {
		try {
			String[] name = new String[10];
			fs = FileSystem.get(new Configuration());
			FileStatus[] fStatusList = fs.listStatus(new Path(path));
			for(int i=0; i<fStatusList.length; i++) {
				System.out.println(fStatusList[i].getPath().getName());
				
				name[i] = fStatusList[i].getPath().getName();
			}
			return name;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	private  void printPath(Path path, int depth) {
		for (int i=0; i<depth; i++) {
			System.out.print("  ");
		}
		System.out.println(path.getName());
	}
	public  boolean putFile(String local,String hdfs) {
		Path locals = new Path(local);
		Path hdf = new Path(hdfs);
		try {
			fs = FileSystem.get(new Configuration());
			fs.copyFromLocalFile(locals, hdf);
			String separator = File.separator;
			String[] split = local.split("\\"+separator);
			boolean exist = exist(hdfs+split[split.length-1]);
			if(exist) {
				return true;
			}
		} catch (Exception e) {
			
		} finally {
			try {
				fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public  boolean getFile(String hdfs,String local) {
		String[] split = hdfs.split("/");
		Path locals = new Path(local);
		Path hdf = new Path(hdfs);
		try {
			fs = FileSystem.get(new Configuration());
			fs.copyToLocalFile(false,hdf, locals);
			File file = new File(local+"\\"+split[split.length-1]);
			 boolean exists = file.exists();
			if(exists){
				return true;
			}
		} catch (Exception e) {
			
		}finally {
			try {
				fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	public  void readFile() {
		try {
			fs = FileSystem.get(new Configuration());
			Path path = new Path("hdfs://hadoop15:9000/hello.txt");
			FSDataInputStream stream = fs.open(path);
			String utf = stream.readUTF();
			System.out.println("读取成功");
			System.out.println(utf);
			stream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public  boolean renameFile(String one,String two) {
		Path oldpath = new Path(one);
		Path newpath = new Path(two);
		try {
			fs = FileSystem.get(new Configuration());
			boolean rename = fs.rename(oldpath, newpath);
			if(rename) {
				return rename;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public  List<Object> listAllFilesOfPath(Path path, int depth){
		List<Object> list = new ArrayList<Object>();
		try {
//			printPath(path, depth);
			fs = FileSystem.get(new Configuration());
			FileStatus[] fsStatusList = fs.listStatus(path);
			for (int i=0; i<fsStatusList.length; i++) {
				Path tmpPath = fsStatusList[i].getPath();
				list.add(tmpPath.getName());
				if (fsStatusList[i].isFile()) {
					// System.out.println(tmpPath.getName());
//					printPath(tmpPath, depth + 1);
				} else {
					listAllFilesOfPath(tmpPath, depth+1);
				}
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public  List<Object> listAllFilesOfPath(String path){
		List<Object> list = listAllFilesOfPath(new Path(path), 0);
		return list;
	}
//	public  void getInfo() {
//		Path oldpath = new Path("/hello.txt");
//		Path newpath = new Path("/");
//		try {
//			fs = FileSystem.get(new Configuration());
//			long size = fs.getDefaultBlockSize(newpath);//整个系统的文件大小
//			System.out.println(size);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			try {
//				fs.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
	public  boolean exist(String path) {
		Path newpath = new Path(path);
		try {
			fs = FileSystem.get(new Configuration());
			boolean exists = fs.exists(newpath);
			if(exists) {
				return exists;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	public  FileStatus info(String path) {
		FileStatus status = null;
		Path newpath = new Path(path);
		try {
			fs = FileSystem.get(new Configuration());
			status = fs.getFileStatus(newpath);
		} catch (Exception e) {
	
		}finally {
			try {
				fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return status;
	}
	public boolean localexist(String path) {
		File file = new File(path);
		boolean exists = file.exists();
		if(exists) {
			return true;
		}
		return false;
	}
	
	@Test
	public void test() {
		String local = "D:\\QMDownload";	
//		String separator = File.separator;
		String hdfs = "/admin";
		List<Object> list = listAllFilesOfPath(hdfs);
		for(Object it:list) {
			System.out.println(it);
		}

	//	listAllFilesOfPath(hdfs);
//		boolean file = putFile(local, hdfs);
//		if(file) {
//			System.out.println("上传成功");
//		}
//		boolean file = putFile(local, hdfs);
//		String[] split = local.split("\\"+separator);
//		System.out.println(split[split.length-1]);
//		Path hdf = new Path(hdfs+"/"+"helloword");
//		boolean b = localexist(local);
//		boolean exist = exist(hdfs);
//		System.out.println(exist);
//		 String one = "/user";
//		 String two = "D:\\user";
//		 hdfsDAO dao = new hdfsDAO();
//		 String[] split = one.split("/");
//		 
//		 File file = new File(two+"\\"+split[split.length-1]);
//		 boolean exists = file.exists();
// 	    boolean file = dao.getFile(one, two);
//		 System.out.println(file);
//		 System.out.println(exists);
//		 System.out.println(split[split.length-1]);
	}
//134217728
}
