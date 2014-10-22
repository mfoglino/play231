package services;

import java.util.List;

import play.libs.F.Promise;
import play.libs.ws.WS;
import play.libs.ws.WSResponse;
import tools.StocksParser;
import entities.StockInfo;

public class StocksInfoRetriever {
	
    public static List<StockInfo> getStocks() {    	
    	
    	String urlPortfolio = "https://trading.portfoliopersonal.com/web/Cotizaciones/tca.aspx?p=1&_c=55";
    	
    	Promise<WSResponse> promiseHobbie = WS.url(urlPortfolio).get();   	
    	Promise<String> hobbieResult = promiseHobbie.map(response -> response.getBody());
    	
    	return StocksParser.parse(hobbieResult.get(1000L));
    }
}
