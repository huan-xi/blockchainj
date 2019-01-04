package xyz.huanxicloud.blockchainj.core.blockchain.block;

import cn.hutool.crypto.digest.DigestUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * merkle tree简单实现
 *
 */
public class MerkleTree {
    /**
     *  transaction List
     */
    private List<String> txList;
    /**
     *  Merkle Root
     */
    private String root;

    /**
     * constructor
     *
     * @param txList
     *         transaction List 交易List
     */
    public MerkleTree(List<String> txList) {
        this.txList = txList;
        root = "";
    }

    /**
     * execute merkle_tree and set root.
     */
    public MerkleTree build() {
        List<String> tempTxList = new ArrayList<>(this.txList);

        List<String> newTxList = getNewTxList(tempTxList);

        while (newTxList.size() != 1) {
            newTxList = getNewTxList(newTxList);
        }

        this.root = newTxList.get(0);
        return this;
    }

    /**
     * return Node Hash List.
     *
     * @param tempTxList
     * list
     * @return
     * 某一层的左右节点相连hash
     */
    private List<String> getNewTxList(List<String> tempTxList) {
        List<String> newTxList = new ArrayList<>();
        int index = 0;
        while (index < tempTxList.size()) {
            // left
            String left = tempTxList.get(index);
            index++;
            // right
            String right = "";
            if (index != tempTxList.size()) {
                right = tempTxList.get(index);
            }
            // sha2 hex value
            String sha2HexValue = DigestUtil.sha256Hex(left + right);
            newTxList.add(sha2HexValue);
            index++;
        }

        return newTxList;
    }

    /**
     * Get Root
     *
     * @return
     * 根节点hash
     */
    public String getRoot() {
        return this.root;
    }

}
