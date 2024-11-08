public class TimeNeededToBuyTickets {

  public static int timeRequiredToBuy(int[] tickets, int k) {

    return countTimeRequiredToBuy(tickets,k,0);
  }

  public static int countTimeRequiredToBuy(int[] tickets, int k, int count){

    if(tickets[k]==0) return count;

    for(int i=0;i<tickets.length;i++){
      if(tickets[i]>0 && tickets[k]!=0){
        tickets[i] = tickets[i]-1;
        count = count + 1;
      }
    }
    return countTimeRequiredToBuy(tickets,k,count);
  }

  public static void main(String[] args) {

    int tickets[]={84,49,5,24,70,77,87,8};
    int k=3;
    int result = timeRequiredToBuy(tickets, k);
    System.out.println(result);
  }
}
