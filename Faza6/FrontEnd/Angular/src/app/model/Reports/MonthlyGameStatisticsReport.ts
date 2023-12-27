import Big from "big.js";
export class MonthlyGameStatisticsReport {
  genre:string;
  publisher:string;
  monthNumber:Big;
  totalReviews:number;
  totalRevenue:Big;
  constructor(
    genre:string,
    publisher:string,
    monthNumber:Big,
    totalReviews:number,
    totalRevenue:Big,
  ){
    this.genre=genre;
    this.publisher=publisher;
    this.monthNumber=monthNumber;
    this.totalReviews=totalReviews;
    this.totalRevenue=totalRevenue;
  }
}
