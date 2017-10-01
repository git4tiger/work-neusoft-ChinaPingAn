package china_p_a;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;


public class Test {

	public static void main(String[] args)  throws ServiceException, MalformedURLException, RemoteException {
		String url = "http://10.176.7.42:8888/services/MainWebService?wsdl";//测试
		//String url = "http://10.176.12.210:9000/services/MainWebService?wsdl";
		//String url = "http://10.176.7.43:8888/services/MainWebService?wsdl";//生产
		
		Service service = new Service();
		Call call = (Call) service.createCall();
		//webService的地址url
		call.setTargetEndpointAddress(new java.net.URL(url));
		//调用的方法名
		call.setOperationName(new QName("http://www.example.org/main/","dataCenterMainWebService"));
		//返回的参数类型
		call.setReturnType(XMLType.XSD_STRING);

		call.addParameter("transNo",XMLType.XSD_STRING,ParameterMode.IN );
		call.addParameter("transBkNo",XMLType.XSD_STRING,ParameterMode.IN );
		call.addParameter("inPrm",XMLType.XSD_STRING,ParameterMode.IN );

//		String qyselect = (String) call.invoke(new Object[]{"WB_LDJY_S409","","{\"parameter\":\"45010000082123\"}"});
//		String qyselect = (String) call.invoke(new Object[]{"WB_LDJY_S410","","{\"parameter\":\"2009-05-20\"}"});
		String qyselect = (String) call.invoke(new Object[]{"WB_LDJY_ZGPA438","","{\"parameter\":\"45010000005870\"}"});

		System.out.println("qyselect===" + qyselect);

	}

}
