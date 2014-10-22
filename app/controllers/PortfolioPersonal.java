package controllers;

import java.util.List;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.StocksInfoRetriever;
import entities.StockInfo;

public class PortfolioPersonal extends Controller {

	
	
    public static Result getStocksValues() {
    	
    	List<StockInfo> stocks = StocksInfoRetriever.getStocks();
    	
    	return ok(Json.toJson(stocks));
    }

}

