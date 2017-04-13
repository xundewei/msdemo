package msdemo.utils;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Name:
 * @Author: TODY
 * @Version: V1.00 
 * @Create Date: 2017年4月13日18:04:07
 * @Description:
 */
public class JaxbDateSerializer extends XmlAdapter<String,Date> {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

    public JaxbDateSerializer() {
        super();


    }
    @Override
    public Date unmarshal(String v) throws Exception {
        return dateFormat.parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        return dateFormat.format(v);
    }
}
