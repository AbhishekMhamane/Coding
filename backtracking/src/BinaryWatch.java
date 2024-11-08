import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinaryWatch {
  public List<String> readBinaryWatch(int turnedOn) {

    String hrAndMin[] = {"1","2","4","8","1.0","2.0","4.0","8.0","16.0","32.0"};
    List<String> res = new ArrayList<String>();
    walkHr(0,turnedOn,hrAndMin,new ArrayList<>(),res);
    Collections.sort(res);
    return res;
  }

  public void walkHr( int index,int turnedOn,String hrAndMin[],List<String> temp, List<String> res) {
    if(turnedOn == 0) {
      int tempMin = 0;
      int tempHr = 0;
      StringBuilder  sb = new StringBuilder();

      for(String i:temp) {
        if(i.contains(".")) {
          tempMin += Integer.parseInt(i.split("\\.")[0]);
        } else {
          tempHr += Integer.parseInt(i);
        }
      }
      if(tempMin < 10) {
        sb.append(tempHr+":0"+tempMin);
      } else {
        sb.append(tempHr+":"+tempMin);
      }
      if(tempHr<12 && tempMin < 60){
        res.add(sb.toString());
      }
      return;
    }

    for(int i=index;i<hrAndMin.length;i++) {
      temp.add(hrAndMin[i]+"");
      walkHr(i+1,turnedOn-1,hrAndMin,temp,res);
      temp.remove(temp.size()-1);
    }
  }

  public static void main(String[] args) {
    int turnedOn = 9;
    BinaryWatch obj = new BinaryWatch();
    System.out.println(obj.readBinaryWatch(turnedOn));
  }
}
