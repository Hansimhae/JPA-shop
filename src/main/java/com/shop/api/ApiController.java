package com.shop.api;


import com.shop.dto.ItemFormDto;
import com.shop.dto.ItemSearchDto;
import com.shop.dto.MainItemDto;
import com.shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    ItemService itemService;

    @GetMapping("/productList")
    public Page<MainItemDto> productList(){
        Pageable pageable = PageRequest.of(0,5);
        ItemSearchDto itemSearchDto = new ItemSearchDto();
        Page<MainItemDto> items=
                itemService.getMainItemPage(itemSearchDto,pageable);
        return items;
    }

    @PostMapping("/productList")
    public Page<MainItemDto> productList2(){
        Pageable pageable = PageRequest.of(0,5);
        ItemSearchDto itemSearchDto = new ItemSearchDto();
        Page<MainItemDto> items=
                itemService.getMainItemPage(itemSearchDto,pageable);
        return items;
    }

    @GetMapping("productDetail/{itemId}")
    public ItemFormDto itemDetail(@PathVariable("itemId") Long itemId){
        ItemFormDto itemFormDto = itemService.getItemDtl(itemId);
        return itemFormDto;
    }
    @PostMapping("testInsert")
    public String testInsert(User user){
        System.out.println("이름: "+user.getName());
        System.out.println("이메일: "+user.getEmail());
        System.out.println("주소: "+user.getAdress());
        System.out.println("tel: "+user.getTel());
        System.out.println("================= 저장 성공");
        return "저장 성공";
    }

    @PostMapping("productInsert")
    public String productInsert(@RequestBody ItemFormDto itemFormDto){
        System.out.println("상품이름: "+itemFormDto.getItemNm());
        System.out.println("상품가격: "+itemFormDto.getPrice());
        System.out.println("상품재고: "+itemFormDto.getStockNumber());
        System.out.println("상품설명: "+itemFormDto.getItemDetail());

        //itemServiec.saveItem(itemFormDto, image);
        System.out.println("================= 저장 성공");
        return "저장 성공";
    }
}
