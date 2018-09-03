package ro.capac.android.capac2018.data.db.model;

import java.util.ArrayList;

import ro.capac.android.capac2018.R;

public class Category {
    public String name;
    public int image;

    public Category(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Category{");
        sb.append("name='").append(name).append('\'');
        sb.append(", image=").append(image);
        sb.append('}');
        return sb.toString();
    }

    public static ArrayList<Category> getAllCategories(){
        ArrayList<Category> categories = new ArrayList<>();

        categories.add(new Category("basketball", R.drawable.basketball));
        categories.add(new Category("bowling", R.drawable.bowling));
        categories.add(new Category("canoeing", R.drawable.canoeing));
        categories.add(new Category("chess & board games", R.drawable.chess));
        categories.add(new Category("cycling", R.drawable.cycling));
        categories.add(new Category("football", R.drawable.football));
        categories.add(new Category("golf", R.drawable.golf));
        categories.add(new Category("gym", R.drawable.gym));
        categories.add(new Category("handball", R.drawable.handball));
        categories.add(new Category("hiking", R.drawable.hiking));
        categories.add(new Category("ice skating", R.drawable.iceskating));
        categories.add(new Category("pool", R.drawable.pool));
        categories.add(new Category("running", R.drawable.running));
        categories.add(new Category("skiing", R.drawable.skiing));
        categories.add(new Category("snowboarding", R.drawable.snowboarding));
        categories.add(new Category("swimming", R.drawable.swimming));
        categories.add(new Category("table tennis", R.drawable.tabletennis));
        categories.add(new Category("tennis", R.drawable.tennis));
        categories.add(new Category("volleyball", R.drawable.volleyball));



        /*
        categories.add(new Category("Basketball", R.drawable.ic_basketball_1));
        categories.add(new Category("Swimming", R.drawable.ic_swimsuit));
        categories.add(new Category("Tennis",R.drawable.ic_tennis));
        categories.add(new Category("Football",R.drawable.ic_football));
        categories.add(new Category("Ping-Pong", R.drawable.ic_pingpong));
        categories.add(new Category("Jogging", R.drawable.ic_treadmill));
        categories.add(new Category("Golf",R.drawable.ic_golf));
        categories.add(new Category("Skiing",R.drawable.ic_ski));
        categories.add(new Category("Snowboarding",R.drawable.ic_snowboard));
        categories.add(new Category("Surf",R.drawable.ic_surf));
        categories.add(new Category("Gym Session",R.drawable.ic_weightlifting));
        categories.add(new Category("American Football",R.drawable.ic_american_football));
        categories.add(new Category("Bowling",R.drawable.ic_bowling));
        categories.add(new Category("Boxing",R.drawable.ic_boxing));
        categories.add(new Category("Chess",R.drawable.ic_chess));
        categories.add(new Category("Hiking",R.drawable.ic_climbing));
        categories.add(new Category("Cricket",R.drawable.ic_cricket));
        categories.add(new Category("Fencing",R.drawable.ic_fencing));
        categories.add(new Category("Hockey",R.drawable.ic_hockey));
        categories.add(new Category("Sailing",R.drawable.ic_kayak));
        categories.add(new Category("Yoga",R.drawable.ic_mat));
        categories.add(new Category("Card Games",R.drawable.ic_poker));
        categories.add(new Category("Pool",R.drawable.ic_pool));
        categories.add(new Category("Voleyball",R.drawable.ic_volleyball));*/
        return categories;
    }
}
