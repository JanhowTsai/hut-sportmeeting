import edu.hut.dao.RecordDao;
import edu.hut.dao.UserDao;
import edu.hut.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    @org.junit.Test
    public void  test1() throws IOException {
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        RecordDao recordDao = session.getMapper(RecordDao.class);
        List<Map<String,Object>> list = recordDao.findPlayerScore();
        for(Map<String,Object> map:list){
            String this_score = (String) map.get("score1");
            String[] scorearray = this_score.split(":");
            Double tran_score = 0.0;
            for(int i=0;i<scorearray.length;i++){
                if(i==0){
                    tran_score+=Double.valueOf(scorearray[i])*3600;
                }else if(i==1){
                    tran_score+=Double.valueOf(scorearray[i])*60;
                }else {
                    tran_score+=Double.valueOf(scorearray[i]);
                }
            }
            if(tran_score==0.0){
                tran_score = 360000.0;
            }
            map.put("tran_score",tran_score);
        }
        System.out.println(list);
        Collections.sort(list, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                int result = 0;
                if((Double)o1.get("tran_score")>(Double)o2.get("tran_score")){
                    result = 1;
                }else if((Double)o1.get("tran_score")<(Double)o2.get("tran_score")){
                    result = -1;
                }else {
                    result = 0;
                }
                return result;
            }
        });
        System.out.println(list);
    }
    @org.junit.Test
    public void test2(){
        String str = "2020-03-04";
        Date date = Date.valueOf(str);
        System.out.println(date);
    }
    @org.junit.Test
    public void test3() throws ParseException {
        Map<String,Integer> map = new HashMap<>();
        map.put("one",1);
        map.put("one",2);
        System.out.println(map);
    }
}
