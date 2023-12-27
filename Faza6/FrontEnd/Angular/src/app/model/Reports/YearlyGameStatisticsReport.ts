import Big from "big.js";

export class YearlyGameStatisticsReport{
  title:string;
  yearNumber:Big;
  totalPlatforms:number;
  averageRating:Big;
  totalSales:Big;
  constructor(
    title:string,
    yearNumber:Big,
    totalPlatforms:number,
    averageRating:Big,
    totalSales:Big,
  ){
    this.title=title;
    this.yearNumber=yearNumber;
    this.totalPlatforms=totalPlatforms;
    this.averageRating=averageRating;
    this.totalSales=totalSales;
  }
}
