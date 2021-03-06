package org.patriques;

import com.google.common.collect.Lists;
import org.patriques.output.AlphaVantageException;
import org.patriques.output.timeseries.Weekly;
import org.patriques.output.timeseries.data.GlobalQuoteData;
import org.patriques.output.timeseries.data.StockData;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String apiKey = "50M3AP1K3Y";
        int timeout = 3000;
        AlphaVantageConnector apiConnector = new AlphaVantageConnector("1S07MX2Y0CK5MUGD", timeout);
        AlphaVantageConnector apiConnector1 = new AlphaVantageConnector("1S07MX2Y0CK5MUGD", timeout);
        TimeSeries stockTimeSeries = new TimeSeries(apiConnector);
        //TimeSeries stockTimeSeries1 = new TimeSeries(apiConnector1);
        // Scanner scanner = new Scanner(System.in);

        //  prompt for the user's name
        //System.out.print("Enter your stock: ");

        // get their input as a String
        //String ticker = scanner.next();

        int i =0;

        String[] ibd100 = {"WWE", "GRUB", "ABMD", "PAYC", "VNOM", "VEEV", "FIVE", "LGND", "FTNT", "TTD", "NOW", "MTCH", "ALGN", "ILMN", "MEDP", "TREX", "HIIQ", "TEAM", "PANW", "NFLX", "ALRM", "SIVB", "CPRT", "WING", "CYBR", "LULU", "NANO", "MOMO", "PLNT", "PGTI", "IDTI", "EHC", "ADBE", "CTRL", "OEC", "ALSN", "MA", "AEO", "ODFL", "ULTA", "BRKS", "MPWR", "RP", "PRAH", "TRU", "UBNT", "KEM", "V", "DG", "JAZZ"};
        String ticker;
        //for (String ticker : ibd100) {
        for(i = 0; i< ibd100.length; i++){
            ticker = ibd100[i];
            try {
                //IntraDay response = stockTimeSeries.intraDay("MSFT", Interval.ONE_MIN, OutputSize.COMPACT);
                Weekly response = stockTimeSeries.weekly(ticker);
                Map<String, String> metaData = response.getMetaData();
                //System.out.println("Information: " + metaData.get("1. Information"));
                //System.out.println("Stock: " + metaData.get("2. Symbol"));

                List<StockData> stockData = (response.getStockData());
                //            List<StockData> stockData = Lists.reverse(response.getStockData());
                int length = stockData.parallelStream().toArray().length;
                final StockData stock = (StockData) stockData.parallelStream().toArray()[1];

  /*              stockData.forEach(stock1 -> {
//                    System.out.println("date:   " + stock.getDateTime());
//                    System.out.println("open:   " + stock.getOpen());
//                    System.out.println("high:   " + stock.getHigh());
//                    System.out.println("low:    " + stock.getLow());
//                    System.out.println("close:  " + stock.getClose());
//
//                    System.out.println("pivot: " + stock.getPivot());
*/
                int len = stock.getDateTime().toString().length();
                String date = stock.getDateTime().toString().substring(0, len - 6);
                String stockDtls = ticker + "," + stock.getOpen() + "," + stock.getHigh() + "," + stock.getLow() + "," + stock.getClose() + "," + "   "
                        + stock.getPivot() + "," + date;

                if (stock.getClose() > stock.getPivot()) {
                    System.out.println(stockDtls + ",     <==GOOD to buy==");
                } else {
                    System.out.println(stockDtls + ",     ==No !! =======>");
                }
                try {
                    Thread.sleep(10000);
                }catch (InterruptedException ex){

                }


                /*    });

                 */

            } catch (AlphaVantageException e) {
                 --i;

            }
        }
        System.out.println(i);
    }
    //  String [] symbols = { "MU", "BILI", "MEDP", "M", "PVTL", "HTHT", "MOMO","IQ","ROKU","ETSY",   "TEAM", "FIVE", "OLLI", "SQ"};
  /*      for (int i = 0; i < symbols.length; i++) {
            if (i >=0 && i <= 4)
            stockTimeSeries.globalQuote(symbols[i]);

        }
*/
    //   GlobalQuoteData json = stockTimeSeries.globalQuote("TEAM");
//        System.out.printf("GlobalQuoteResponse: "+ json);
////

    //  try {
//            IntraDay response = stockTimeSeries.intraDay("TEAM", Interval.ONE_MIN, OutputSize.COMPACT);
//            Daily dResponse = stockTimeSeries.daily("TEAM",  OutputSize.COMPACT);


    //DailyAdjusted response = stockTimeSeries.dailyAdjusted("TEAM");
//
//             Map<String, String> metaData = response.getMetaData();
//            System.out.println("Information: " + metaData.get("1. Information"));
//            System.out.println("Stock: " + metaData.get("2. Symbol"));
//
//            List<StockData> stockData = response.getStockData();
//            stockData.forEach(stock -> {
//                System.out.println("date:   " + stock.getDateTime());
//                System.out.println("open:   " + stock.getOpen());
//                System.out.println("high:   " + stock.getHigh());
//                System.out.println("low:    " + stock.getLow());
//                System.out.println("close:  " + stock.getClose());
//                System.out.println("volume: " + stock.getVolume());
//            });
//        } catch (AlphaVantageException e) {
//            System.out.println("something went wrong");
//        }
}