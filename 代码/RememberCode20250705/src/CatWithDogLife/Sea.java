package CatWithDogLife;

/**
 * @author pluchon
 * @create 2025-07-06-09:09
 * 作者代码水平一般，难免难看，请见谅
 */
public class Sea {
    public void sunrise(){
        System.out.println("太阳升起");
    }

    public void wave(){
        System.out.println("海啸山河翻滚");
    }

    public void deepToSea(){
        System.out.println("潜入深海");
    }

    public void sunset(){
        System.out.println("太阳落下");
    }

    public void life(ISwimable iSwimable){
        if(iSwimable instanceof Fish){
            Animal fish = new Fish("啾啾",1,"面包屑","能动态变色","能动态发光","擅长伪装");
            fish.voice();
        }
        iSwimable.swim();
    }
}
