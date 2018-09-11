package org.patriques.output.timeseries.data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Representation of json object, i.e:
 * "2017-07-06": {
 *   "1. open": "68.2700",
 *   "2. high": "68.7800",
 *   "3. low": "68.1200",
 *   "4. close": "68.5700",
 *   "5. adjusted close": "67.8632",
 *   "6. volume": "20776555",
 *   "7. dividend amount": "0.0000",
 *   "8. split coefficient": "1.0000"
 * }
 */
public class StockData {
  private final LocalDateTime dateTime;
  private final double open;
  private final double high;
  private final double low;
  private final double close;
  private final double adjustedClose;
  private final long volume;
  private final double dividendAmount;
  private final double splitCoefficient;
  private final double pivot;

  public StockData(LocalDateTime dateTime,
                   double open,
                   double high,
                   double low,
                   double close,
                   double adjustedClose,
                   long volume,
                   double dividendAmount,
                   double splitCoefficient,double pivot) {
    this.dateTime = dateTime;
    this.open = open;
    this.high = high;
    this.low = low;
    this.close = close;
    this.adjustedClose = adjustedClose;
    this.volume = volume;
    this.dividendAmount = dividendAmount;
    this.splitCoefficient = splitCoefficient;
    this.pivot = (high + low  + close)/3;
  }

  public StockData(LocalDateTime dateTime,
                   double open,
                   double high,
                   double low,
                   double close,
                   double adjustedClose,
                   long volume,
                   double dividendAmount,double pivot) {
    this.dateTime = dateTime;
    this.open = open;
    this.high = high;
    this.low = low;
    this.close = close;
    this.adjustedClose = adjustedClose;
    this.volume = volume;
    this.dividendAmount = dividendAmount;
    this.splitCoefficient = 0;
    this.pivot  = (high + low  + close)/3;
  }

  public StockData(LocalDateTime dateTime,
                   double open,
                   double high,
                   double low,
                   double close,
                   long volume,
                   double pivot) {
    this.dateTime = dateTime;
    this.open = open;
    this.high = high;
    this.low = low;
    this.close = close;
    this.adjustedClose = 0;
    this.volume = volume;
    this.dividendAmount = 0;
    this.splitCoefficient = 0;
    this.pivot =  (high + low  + close)/3;
  }

  public LocalDateTime getDateTime() {
    return dateTime;
  }

  public double getOpen() {
    return getaDouble(open);
  }

  public double getHigh() {
    return getaDouble(high);
  }

  public double getLow() {
    return getaDouble(low);
  }

  public double getClose() {
    return getaDouble(close);
  }

  public double getAdjustedClose() {
    return adjustedClose;
  }

  public long getVolume() {
    return volume;
  }

  public double getDividendAmount() {
    return dividendAmount;
  }

  public double getSplitCoefficient() {
    return splitCoefficient;
  }

  public double getPivot() {
    return getaDouble(pivot);
  }

  private double getaDouble(double amt) {
    return new BigDecimal(amt).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
  }
}
