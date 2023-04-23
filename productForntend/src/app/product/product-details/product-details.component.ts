import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/entity/product';
import { Deliverable } from 'src/app/entity/deveriable';
import { ProductService } from 'src/app/shared/product.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {

  constructor(private activeRoute:ActivatedRoute,private productService:ProductService) { }
  product:Product|undefined;
  productId:string | undefined;
  deliverable:Deliverable|undefined;
  public pincode = new FormGroup({
    pincode: new FormControl("",[Validators.required,Validators.email]),
 });

  ngOnInit(): void {
    this.productId = <string>this.activeRoute.snapshot.paramMap.get("productId");
    this.productService.getProductById(this.productId).subscribe(data=>{
      this.product=data;
    });
  }

  searchPincode(){
    this.productService.isDevlirable(<string>this.pincode.value.pincode,<string>this.productId).subscribe(data=>{
      console.log(data);
      this.deliverable = data;
    });
  }

}
