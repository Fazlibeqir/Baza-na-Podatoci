import Big from "big.js";
import {Game} from "./game";
import {Promotion} from "./promotion";

export class Order{
  id_order:number;
  status:string;
  order_date:Date;
  total_amount:Big;
  id_costumer:number;
  id_payment:number;
  ListOfGames:Game[];
  ListOfPromotions:Promotion[];

    constructor(
        id_order:number,
        status:string,
        order_date:Date,
        total_amount:Big,
        id_costumer:number,
        id_payment:number,
        ListOfGames:Game[],
        ListOfPromotions:Promotion[]
    ){
        this.id_order=id_order;
        this.status=status;
        this.order_date=order_date;
        this.total_amount=total_amount;
        this.id_costumer=id_costumer;
        this.id_payment=id_payment;
        this.ListOfGames=ListOfGames;
        this.ListOfPromotions=ListOfPromotions;
    }
}
