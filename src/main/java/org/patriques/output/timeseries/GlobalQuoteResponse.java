package org.patriques.output.timeseries;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.patriques.output.AlphaVantageException;
import org.patriques.output.JsonParser;
import org.patriques.output.timeseries.data.GlobalQuoteData;
import org.patriques.output.timeseries.data.StockData;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Representation of Global quote response from api.
 *
 * @see TimeSeriesResponse
 */
public class GlobalQuoteResponse {

    private GlobalQuoteResponse(final Map<String, String> metaData,
                                final List<StockData> stockData) {
        //super(metaData, stockData);
    }

    /**
     * Creates {@code Daily} instance from json.
     *
     * @param json string to parse
     * @return Daily instance
     */
    public static GlobalQuoteData from(String json)  {
        Parser parser = new Parser();
        return parser.parseJson(json);
    }

    /**
     * Helper class for parsing json to {@code Daily}.
     *
     * @see TimeSeriesParser
     * @see JsonParser
     */
    private static class Parser extends JsonParser<GlobalQuoteData> {

        String getStockDataKey() {
            return "Global Quote";
        }




        @Override
        protected GlobalQuoteData resolve(JsonObject rootObject) {

            Type metaDataType = new TypeToken<Map<String, String>>() {
            }.getType();
            Type dataType = new TypeToken<Map<String, String>>() {}.getType();

/**
 * Representation of json object, i.e:
 "Global Quote": {
 "01. symbol": "MSFT",
 "02. open": "108.2300",
 "03. high": "108.7248",
 "04. low": "107.2300",
 "05. price": "108.2100",
 "06. volume": "19021569",
 "07. latest trading day": "2018-09-07",
 "08. previous close": "108.7400",
 "09. change": "-0.5300",
 "10. change percent": "-0.4874%"
 * }
 */
      //      List<StockData> stocks = new ArrayList<>();
          //  try {
            final JsonElement jsonElement = rootObject.get(getStockDataKey());
                         String symbol = jsonElement.getAsJsonObject().get("01. symbol").toString();
                         Double open = Double.valueOf(jsonElement.getAsJsonObject().get("02. open").toString().replace("\"", ""));;
            Double high = Double.valueOf(jsonElement.getAsJsonObject().get("03. high").toString().replace("\"", ""));
            Double low = Double.valueOf(jsonElement.getAsJsonObject().get("04. low").toString().replace("\"", ""));
            Double closePrice = Double.valueOf(jsonElement.getAsJsonObject().get("05. price").toString().replace("\"", ""));
             String volume = jsonElement.getAsJsonObject().get("06. volume").toString();
             String tradDay = jsonElement.getAsJsonObject().get("07. latest trading day").toString();
             Double prevClose = Double.valueOf(jsonElement.getAsJsonObject().get("08. previous close").toString().replace("\"", ""));
             String change = jsonElement.getAsJsonObject().get("09. change").toString();
             String changePercent = jsonElement.getAsJsonObject().get("10. change percent").toString();

            //                String date = stock.getDateTime().toString().substring(0, len - 6);
                String stockDtls = symbol + "," + open + "," +
                        high +
                        "," + low + "," + closePrice + ","
                        + (BigDecimal.valueOf(high).add(BigDecimal.valueOf(closePrice).add( BigDecimal.valueOf(low))).doubleValue()/3);
//                        + stock.getPivot() + "," + date;
            System.out.printf(stockDtls);
         //Map<String, String> metaData = GSON.fromJson(rootObject.get("Meta Data"), metaDataType);

//            final JsonElement jsonElement = rootObject.get(getStockDataKey());
//            System.out.println(jsonElement.getAsJsonObject().entrySet());
//            final Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
           return null;
        }
    }

}
