import { Button, Stack, TextField, Typography } from "@mui/material";
import RegisterIcon from "@mui/icons-material/AppRegistrationRounded";
import ArrowForwardIcon from "@mui/icons-material/ArrowForward";
import { Link } from "react-router-dom";

export default function Login() {
  return (
    <Stack
      spacing={3}
      sx={{
        width: "100%",
      }}
    >
      <Stack spacing={1}>
        <Typography
          component="h1"
          variant="h5"
          sx={{
            fontWeight: 700,
          }}
        >
          Se connecter
        </Typography>

        <Typography variant="body2" color="text.secondary">
          Accédez à votre compte
        </Typography>
      </Stack>

      <Stack component="form" spacing={2}>
        <TextField label="Votre email" type="email" size="small" fullWidth />

        <TextField
          label="Mot de passe"
          type="password"
          size="small"
          fullWidth
        />

        <Stack
          direction="row"
          spacing={2}
          sx={{
            pt: 1,
          }}
        >
          <Button
            variant="outlined"
            fullWidth
            startIcon={<RegisterIcon />}
            component={Link}
            to="/register"
          >
            Créer un compte
          </Button>

          <Button
            variant="contained"
            fullWidth
            startIcon={<ArrowForwardIcon />}
          >
            Se connecter
          </Button>
        </Stack>
      </Stack>
    </Stack>
  );
}
