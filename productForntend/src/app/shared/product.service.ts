import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http"
import { Product } from '../entity/product';
import { Deliverable } from '../entity/deveriable';

@Injectable({
  providedIn: 'root'
})

export class ProductService {

  constructor(private _http:HttpClient) { }
  baseUrl: string ="http://127.0.0.1:9099";
  getAllProduct(){
    return this._http.get<Product[]>(`${this.baseUrl}/products/`);
  }

  getProductById(id:string){
    return this._http.get<Product>(`${this.baseUrl}/products/detail/${id}`);
  }
  
  isDevlirable(pincode:string,productId:string){
    return this._http.get<Deliverable>(`${this.baseUrl}/deliverable/${productId}/${pincode}`);
  }

  searchKeyword(keyword:string){
    return this._http.get<Product[]>(`${this.baseUrl}/products/${keyword}`);
  }
}
