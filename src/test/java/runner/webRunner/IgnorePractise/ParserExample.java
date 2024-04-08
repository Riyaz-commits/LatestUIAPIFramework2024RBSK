package runner.webRunner.IgnorePractise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParserExample {

    public static void main(String[] args) throws JsonProcessingException {


        String list_of_strings ="This is a string, This is another string, This is yet another string, This is a fourth string, This is a fifth string, This is a sixth string, This is a seventh string, This is an eighth string, This is a ninth string, This is a tenth string, This is an eleventh string, This is a twelfth string, This is a thirteenth string, This is a fourteenth string, This is a fifteenth string, This is a sixteenth string, This is a seventeenth string, This is an eighteenth string, This is a nineteenth string, This is a twentieth string, This is a twenty-first string, This is a twenty-second string, This is a twenty-third string, This is a twenty-fourth string, This is a twenty-fifth string, This is a twenty-sixth string, This is a twenty-seventh string, This is a twenty-eighth string, This is a twenty-ninth string, This is a thirtieth string, This is a thirty-first string, This is a thirty-second string, This is a thirty-third string, This is a thirty-fourth string, This is a thirty-fifth string, This is a thirty-sixth string, This is a thirty-seventh string, This is a thirty-eighth string, This is a thirty-ninth string, This is a fortieth string, This is a forty-first string, This is a forty-second string, This is a forty-third string, This is a forty-fourth string, This is a forty-fifth string, This is a forty-sixth string, This is a forty-seventh string, This is a forty-eighth string, This is a forty-ninth string, This is a fiftieth string, This is a fifty-first string, This is a fifty-second string, This is a fifty-third string, This is a fifty-fourth string, This is a fifty-fifth string, This is a fifty-sixth string, This is a fifty-seventh string, This is a fifty-eighth string, This is a fifty-ninth string, This is a sixtieth string, This is a sixty-first string, This is a sixty-second string, This is a sixty-third string, This is a sixty-fourth string, This is a sixty-fifth string, This is a sixty-sixth string, This is a sixty-seventh string, This is a sixty-eighth string, This is a sixty-ninth string, This is a seventieth string, This is a seventy-first string, This is a seventy-second string, This is a seventy-third string, This is a seventy-fourth string, This is a seventy-fifth string, This is a seventy-sixth string, This is a seventy-seventh string, This is a seventy-eighth string, This is a seventy-ninth string, This is an eightieth string, This is an eighty-first string, This is an eighty-second string, This is an eighty-third string, This is an eighty-fourth string, This is an eighty-fifth string, This is an eighty-sixth string, This is an eighty-seventh string, This is an eighty-eighth string, This is an eighty-ninth string, This is a ninetieth string, This is a ninety-first string, This is a ninety-second string, This is a ninety-third string, This is a ninety-fourth string, This is a ninety-fifth string, This is a ninety-sixth string, This is a ninety-seventh string, This is a ninety-eighth string, This is a ninety-ninth string, This is a hundredth string";

      List<String> product= Arrays.asList(list_of_strings.split(","));
    //    System.out.println(product);
        ProductList productList = new ProductList();
        Product p = new Product();
        int counter =1;
        List<Product> expectedList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        String pName= null;
for( int i =0; i<product.size()-5;i++)
{

           pName= product.get(i ++);
      String     pdesc= product.get(i++);
            productList.setCodeNumber(product.get(i++));
            productList.setPriceDollar(product.get(i++));
            productList.setDescription(product.get(i++));
            productList.setPrice(product.get(i++));
            p.setProductList(productList);
            p.setProductName(pName);
          expectedList.add(p);
    System.out.println(objectMapper.writeValueAsString(expectedList));
       //     p.setProductName(pName);
         //expectedList.add(p);




}

    }
}
