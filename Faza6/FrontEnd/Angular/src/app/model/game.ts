import Big from "big.js";

export class Game {
    title: string;
    genre: string;
    price: Big;
    developer: string;
    stock: number;
    releaseDate: Date;
    idPublisher: number;
    constructor(
        title: string,
        genre: string,
        price: Big,
        developer: string,
        stock: number,
        releaseDate: Date,
        idPublisher: number,
    ) {
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.developer = developer;
        this.stock = stock;
        this.releaseDate = releaseDate;
        this.idPublisher = idPublisher;
    }
}
