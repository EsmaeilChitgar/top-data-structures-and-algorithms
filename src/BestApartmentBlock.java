import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Block{
    public Block(boolean gym, boolean school, boolean store){
        this.gym = gym;
        this.school = school;
        this.store = store;
    }
    public boolean gym;
    public boolean school;
    public boolean store;
}

class BlockDist {
    public int gymDist = 100;
    public int schoolDist = 100;
    public int storeDist = 100;
}
public class BestApartmentBlock {
    public void calc(List<Block> blocks, Block req) {
        List<BlockDist> blockDistList = new ArrayList<>(blocks.size()){};
        for (int i = 0; i < blocks.size(); i++) {
            blockDistList.add(new BlockDist());
        }

        calcBlockListDist(blocks, blockDistList);
        calcBlockListDistReverse(blocks, blockDistList);

        List<Integer> listFarthestDistanceOfBlocks = blockDistList.stream().map(bld -> Math.max(Math.max(bld.gymDist, bld.schoolDist), bld.storeDist)).toList();
        int valueOfMinBlock = Collections.min(listFarthestDistanceOfBlocks);
        int indexOfMinBlock = listFarthestDistanceOfBlocks.indexOf(valueOfMinBlock);

        System.out.println(valueOfMinBlock + "---" + indexOfMinBlock);
    }

    private static void calcBlockListDist(List<Block> blocks, List<BlockDist> blockDistList) {
        BlockDist prevBlockDist = new BlockDist();

        for (int i = 0; i < blocks.size(); i++) {
            Block block = blocks.get(i);
            BlockDist dist = blockDistList.get(i);
            if (block.gym) {
                dist.gymDist = 0;
            } else {
                dist.gymDist = Math.min(dist.gymDist, prevBlockDist.gymDist + 1);
            }

            if (block.school) {
                dist.schoolDist = 0;
            } else {
                dist.schoolDist = Math.min(dist.schoolDist, prevBlockDist.schoolDist + 1);
            }

            if (block.store) {
                dist.storeDist = 0;
            } else {
                dist.storeDist = Math.min(dist.storeDist, prevBlockDist.storeDist + 1);
            }

            prevBlockDist = dist;
        }
    }

    private static void calcBlockListDistReverse(List<Block> blocks, List<BlockDist> blockDistList) {
        BlockDist prevBlockDist = new BlockDist();

        for (int i = blocks.size()-1; i >= 0; i--) {
            Block block = blocks.get(i);
            BlockDist dist = blockDistList.get(i);
            if (block.gym) {
                dist.gymDist = 0;
            } else {
                dist.gymDist = Math.min(dist.gymDist, prevBlockDist.gymDist + 1);
            }

            if (block.school) {
                dist.schoolDist = 0;
            } else {
                dist.schoolDist = Math.min(dist.schoolDist, prevBlockDist.schoolDist + 1);
            }

            if (block.store) {
                dist.storeDist = 0;
            } else {
                dist.storeDist = Math.min(dist.storeDist, prevBlockDist.storeDist + 1);
            }

            prevBlockDist = dist;
        }
    }


    public static void main(String[] args) {
        List<Block> blocks = List.of(
                new Block(false, true, false)
                , new Block(true, false, false)
                , new Block(true, true, false)
                , new Block(false, true, false)
                , new Block(false, true, true));

        Block req = new Block(true, true, true);

        BestApartmentBlock bab = new BestApartmentBlock();
        bab.calc(blocks, req);
    }

}
