package org.patriques.output.timeseries.data;

import org.patriques.output.JsonParser;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

public class GlobalQuoteData {
  private String symbol;
  private final double open;
  private final double high;
  private final double low;
  private final double close;
  private final long volume;
  private final LocalDateTime latestTradingDate;
  private final double prevClose;
  private final double change;
  private final double perChange;

  public GlobalQuoteData(String symbol,
                         double open,
                         double high,
                         double low,
                         double close,
                         long volume,
                         LocalDateTime latestTradingDate,
                         double prevClose,
                         double change,
                         double perChange
                         ) {
    this.symbol = symbol;
    this.open = open;
    this.high = high;
    this.low = low;
    this.close = close;
    this.volume = volume;
    this.latestTradingDate = latestTradingDate;
    this.prevClose = prevClose;
    this.change = (change);
    this.perChange = (perChange);
  }

  public GlobalQuoteData(String symbol,
                         String open,
                         String high,
                         String low,
                         String close,
                         String volume,
                         String latestTradingDate,
                         String prevClose,
                         String change,
                         String perChange) {
    this.symbol = symbol;
    this.open = Double.parseDouble(open);
    this.high = Double.parseDouble(high);
    this.low = Double.parseDouble(low);
    this.close = Double.parseDouble(close);
    this.volume = Long.parseLong(volume);
    this.latestTradingDate = LocalDate.parse( latestTradingDate, JsonParser.SIMPLE_DATE_FORMAT).atStartOfDay();
    this.prevClose = Double.parseDouble(prevClose);
    this.change = Double.parseDouble(change);
    this.perChange = Double.parseDouble(perChange);
  }




  public double getOpen() {
    return open;
  }

  public double getHigh() {
    return high;
  }

  public double getLow() {
    return low;
  }

  public double getClose() {
    return close;
  }


  public long getVolume() {
    return volume;
  }


  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public LocalDateTime getLatestTradingDate() {
    return latestTradingDate;
  }

  public double getPrevClose() {
    return prevClose;
  }

  @Override
  public String toString() {
    return "GlobalQuoteData{" +
            "symbol='" + symbol + '\'' +
            ", open=" + open +
            ", high=" + high +
            ", low=" + low +
            ", close=" + close +
            ", volume=" + volume +
            ", latestTradingDate=" + latestTradingDate +
            ", prevClose=" + prevClose +
            ", change=" + change +
            ", perChange=" + perChange +
            '}';
  }
}
