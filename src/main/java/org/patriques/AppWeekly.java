package org.patriques;

import org.patriques.output.AlphaVantageException;
import org.patriques.output.timeseries.Weekly;
import org.patriques.output.timeseries.data.GlobalQuoteData;
import org.patriques.output.timeseries.data.StockData;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AppWeekly {
    public static void main(String[] args) {
        String apiKey = "50M3AP1K3Y";
        int timeout = 3000;
        AlphaVantageConnector apiConnector = new AlphaVantageConnector(apiKey, timeout);
        AlphaVantageConnector apiConnector1 = new AlphaVantageConnector("1S07MX2Y0CK5MUGD", timeout);
        TimeSeries stockTimeSeries = new TimeSeries(apiConnector1);
        //TimeSeries stockTimeSeries1 = new TimeSeries(apiConnector1);
        // Scanner scanner = new Scanner(System.in);

        //  prompt for the user's name
        //System.out.print("Enter your stock: ");

        // get their input as a String
        //String ticker = scanner.next();

        int i = 0;

        String[] ibd100 = {"DDPT", "XOM", "GE", "GS", "HD", "INTC", "IBM", "JNJ", "JPM", "MCD", "MRK", "MSFT"
                , "NKE", "PFE", "PG", "TRV", "UTX", "UNH", "VZ", "V", "WMT", "BAC", "JPM", "MMM", "AXP", "AAPL", "BA", "CAT", "CVX", "CSCO", "KO", "DIS",
                "WWE", "GRUB", "ABMD", "PAYC", "VNOM", "VEEV", "FIVE", "LGND", "FTNT", "TTD", "NOW", "MTCH", "ALGN", "ILMN", "MEDP",
                "TREX", "HIIQ", "TEAM", "PANW", "NFLX", "ALRM", "SIVB", "CPRT", "WING", "CYBR", "LULU", "NANO", "MOMO", "PLNT", "PGTI",
                "IDTI", "EHC", "ADBE", "CTRL", "OEC", "ALSN", "MA", "AEO", "ODFL", "ULTA", "BRKS", "MPWR", "RP", "PRAH", "TRU", "UBNT",
                "KEM", "V", "DG", "JAZZ"};

        Arrays.sort(ibd100);
        String ticker;
        //for (String ticker : ibd100) {
        for (i = 0; i < ibd100.length; i++) {
            ticker = ibd100[i];
            try {

//
//                if (stock.getClose() > stock.getPivot()) {
//                    System.out.println(stockDtls + ",     <==GOOD to buy==");
//                } else {
//                    System.out.println(stockDtls + ",     ==No !! =======>");
//                }
//                try {
//                    Thread.sleep(10000);
//                }catch (InterruptedException ex){




                /*    });

                 */


                System.out.println(i);
                //}
                //  String [] symbols = { "MU", "BILI", "MEDP", "M", "PVTL", "HTHT", "MOMO","IQ","ROKU","ETSY",   "TEAM", "FIVE", "OLLI", "SQ"};
                // for (int i = 0; i < ibd100.length; i++) {
                // if (i >=0 && i <= 4)
                final GlobalQuoteData globalQuoteData = stockTimeSeries.globalQuote(ibd100[i]);
                //System.out.println(globalQuoteData);

//        int len = stock.getDateTime().toString().length();
//                String date = stock.getDateTime().toString().substring(0, len - 6);
//                String stockDtls = ticker + "," + stock.getOpen() + "," + stock.getHigh() + "," + stock.getLow() + "," + stock.getClose() + "," + "   "
//                        + stock.getPivot() + "," + date;
//
            } catch (AlphaVantageException e) {
                --i;

            }

        }
    }
}