package tools;

import java.util.ArrayList;
import java.util.List;

import entities.StockInfo;

public class StocksParser {

	
	public static List<StockInfo> parse(String stocksInfo)
	{
		
		stocksInfo = stocksInfo.replaceAll("\\01\\:", "XXX");
		String[] lines = stocksInfo.split("\\01\\");
		
		List<StockInfo> stocks = new ArrayList<StockInfo>();
		for (String line : lines) {			
			System.out.println(line);
			//stocks.add(parseStockLine(line));			
		}
		
		return stocks;
	}

	private static StockInfo parseStockLine(String line) {
		StockInfo stock = new StockInfo();
		
		String[] fields = line.split("|");
		
		stock.setId(fields[0]);
		stock.setName(fields[1]);
		stock.setVenta(toFloat(fields[3]));

		return stock;
	}

	private static Float toFloat(String value) {
		
		value = value.replaceAll(".", "|");
		value = value.replaceAll(",", ".");
		value = value.replaceAll("|", ",");
				
		return Float.valueOf(value);
	}
}
