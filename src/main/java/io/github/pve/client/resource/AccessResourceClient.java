package io.github.pve.client.resource;

import io.github.pve.client.exception.ProxmoxApiException;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import io.github.pve.client.model.access.Acl;
import io.github.pve.client.model.access.Role;
import io.github.pve.client.model.access.User;
import io.github.pve.client.model.access.options.UserCreationOptions;
import io.github.pve.client.exception.ProxmoxAuthException;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 访问控制资源客户端 (用户, 组, 角色, ACLs).
 */
public class AccessResourceClient extends BaseResourceClient {
    public AccessResourceClient(ProxmoxApiExecutor executor) {
        super(executor);
    }

    /**
     * 列出所有用户。
     */
    public List<User> listUsers() throws ProxmoxApiException, ProxmoxAuthException {
        PveResponse<List<User>> response = executor.get("/access/users", null, new TypeReference<>() {});
        return response.getData().orElse(Collections.emptyList());
    }

    /**
     * 获取指定用户的详细信息。
     */
    public User getUser(String userId) throws ProxmoxApiException, ProxmoxAuthException {
        String path = "/access/users/" + userId;
        // The response for a single user is not wrapped in "data", so we expect the raw object.
        PveResponse<User> response = executor.get(path, null, new TypeReference<>() {});
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Get User data is null", response.getStatusCode(), null, null, path));
    }

    /**
     * 创建一个新用户。
     */
    public void createUser(String userId, UserCreationOptions options) throws ProxmoxApiException, ProxmoxAuthException {
        String path = "/access/users";
        Map<String, Object> params = ProxmoxApiExecutor.getObjectMapper().convertValue(options, new TypeReference<>() {});
        params.put("userid", userId);
        executor.post(path, null, params, new TypeReference<Void>() {});
    }

    /**
     * 更新一个用户信息。
     */
    public void updateUser(String userId, UserCreationOptions options) throws ProxmoxApiException, ProxmoxAuthException {
        String path = "/access/users/" + userId;
        Map<String, Object> params = ProxmoxApiExecutor.getObjectMapper().convertValue(options, new TypeReference<>() {});
        executor.put(path, null, params, new TypeReference<Void>() {});
    }

    /**
     * 删除一个用户。
     */
    public void deleteUser(String userId) throws ProxmoxApiException, ProxmoxAuthException {
        String path = "/access/users/" + userId;
        executor.delete(path, null, null, new TypeReference<Void>() {});
    }

    // --- Methods for Groups, Roles, ACLs can be added similarly ---

    /**
     * 列出所有角色。
     */
    public List<Role> listRoles() throws ProxmoxApiException, ProxmoxAuthException {
        PveResponse<List<Role>> response = executor.get("/access/roles", null, new TypeReference<>() {});
        return response.getData().orElse(Collections.emptyList());
    }

    /**
     * 列出所有ACLs。
     */
    public List<Acl> listAcls() throws ProxmoxApiException, ProxmoxAuthException {
        PveResponse<List<Acl>> response = executor.get("/access/acl", null, new TypeReference<>() {});
        return response.getData().orElse(Collections.emptyList());
    }
}
