import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ProductService } from 'src/app/shared/product.service';
import { Router } from '@angular/router';
import { HtmlParser } from '@angular/compiler';
import { Product } from 'src/app/entity/product';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { CheckboxModel } from 'src/app/entity/checkBoxModel';

@Component({
  selector: 'app-userdashboard',
  templateUrl: './userdashboard.component.html',
  styleUrls: ['./userdashboard.component.css']
})
export class UserdashboardComponent implements OnInit {

  constructor(private productService: ProductService, private route: Router) { }
  pricePanelOpen: boolean=false;
  brandPanelOpen:boolean=true;
  priceP: number= 0 ;
  products: Product[] = [];
  searchResult: Product[] = [];
  brands: CheckboxModel[] =
    [
      { label: "Puma", selected: true },
      { label: "Adidas", selected: true },
      { label: "Nike", selected: true }
    ];

  public searchForm = new FormGroup({
    search: new FormControl("", [Validators.required]),
  });

  ngOnInit(): void {
    this.productService.getAllProduct().subscribe((data) => {
      this.products = data;
      this.searchResult = data;
    });
  }


  getdetails(produtCode: any) {
    this.route.navigate([`/details/${produtCode}`]);
  }

  
  searchProduct() {
    this.productService.searchKeyword(<string>this.searchForm.value.search).subscribe(data => {
      this.products = data;
    })
    this.filterProduct();
  }

  filterProduct() {
    console.log(" the value is changinig");
    this.products = this.searchResult.filter((x: { price: number; }) => {
      if (x.price <= this.priceP) {
        return x;
      }
      return;
    })
  }


  filterProductsByBrand(brand: CheckboxModel) {
    brand.selected = !brand.selected;
    this.products = this.searchResult.filter((x) => {
      if (this.brands.find(y => {
        return (x.brand == y.label && y.selected);
      })) {
        return x;
      }
      return;
    });
  }
}
